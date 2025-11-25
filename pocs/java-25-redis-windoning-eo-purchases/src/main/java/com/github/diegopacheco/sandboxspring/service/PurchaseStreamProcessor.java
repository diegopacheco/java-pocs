package com.github.diegopacheco.sandboxspring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.diegopacheco.sandboxspring.model.Purchase;
import io.lettuce.core.Consumer;
import io.lettuce.core.RedisBusyException;
import io.lettuce.core.StreamMessage;
import io.lettuce.core.TransactionResult;
import io.lettuce.core.XReadArgs;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.models.stream.PendingMessages;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PurchaseStreamProcessor {
    private static final String STREAM_KEY = "purchases";
    private static final String CONSUMER_GROUP = "purchase-processor-group";
    private static final String CONSUMER_NAME = "processor-1";
    private static final String OFFSET_KEY = "offset:" + CONSUMER_NAME;
    private static final String TOTAL_DEBT_PREFIX = "total:";
    private static final String HISTORY_PREFIX = "history:";
    private static final String DEDUP_PREFIX = "dedup:";
    private static final int MAX_HISTORY = 20;
    private static final int DEDUP_TTL_SECONDS = 86400;

    private final RedisCommands<String, String> redisCommands;
    private final ObjectMapper objectMapper;
    private final Map<String, BigDecimal> totalDebtCache;
    private final Map<String, List<Purchase>> historyCache;
    private volatile boolean running = true;

    public PurchaseStreamProcessor(RedisCommands<String, String> redisCommands) {
        this.redisCommands = redisCommands;
        this.objectMapper = new ObjectMapper();
        this.totalDebtCache = new ConcurrentHashMap<>();
        this.historyCache = new ConcurrentHashMap<>();
    }

    @PostConstruct
    public void startProcessing() {
        initializeConsumerGroup();
        Thread processorThread = new Thread(() -> {
            while (running && !Thread.currentThread().isInterrupted()) {
                try {
                    List<StreamMessage<String, String>> messages = redisCommands.xreadgroup(
                            Consumer.from(CONSUMER_GROUP, CONSUMER_NAME),
                            XReadArgs.StreamOffset.lastConsumed(STREAM_KEY)
                    );

                    for (StreamMessage<String, String> message : messages) {
                        processMessageWithTransaction(message);
                    }

                    if (messages.isEmpty()) {
                        processPendingMessages();
                        Thread.sleep(100);
                    }
                } catch (Exception e) {
                    System.err.println("Error processing stream: " + e.getMessage());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        });
        processorThread.setDaemon(true);
        processorThread.start();
    }

    @PreDestroy
    public void stopProcessing() {
        running = false;
    }

    private void initializeConsumerGroup() {
        try {
            redisCommands.xgroupCreate(
                    XReadArgs.StreamOffset.from(STREAM_KEY, "0-0"),
                    CONSUMER_GROUP
            );
        } catch (RedisBusyException e) {
        }
    }

    private void processPendingMessages() {
        try {
            PendingMessages pending = redisCommands.xpending(
                    STREAM_KEY,
                    CONSUMER_GROUP
            );

            if (pending == null || pending.getCount() == 0) {
                return;
            }

            List<StreamMessage<String, String>> messages = redisCommands.xreadgroup(
                    Consumer.from(CONSUMER_GROUP, CONSUMER_NAME),
                    XReadArgs.StreamOffset.lastConsumed(STREAM_KEY)
            );

            for (StreamMessage<String, String> message : messages) {
                processMessageWithTransaction(message);
            }
        } catch (Exception e) {
        }
    }

    private void processMessageWithTransaction(StreamMessage<String, String> message) {
        try {
            Map<String, String> body = message.getBody();
            String userId = body.get("userId");
            String purchaseJson = body.get("data");
            Purchase purchase = objectMapper.readValue(purchaseJson, Purchase.class);
            String purchaseId = purchase.getPurchaseId();
            String dedupKey = DEDUP_PREFIX + purchaseId;

            boolean success = false;
            int maxRetries = 100;
            int retries = 0;

            while (!success && retries < maxRetries) {
                try {
                    redisCommands.watch(dedupKey);

                    String dedupValue = redisCommands.get(dedupKey);
                    if (dedupValue != null) {
                        redisCommands.unwatch();
                        redisCommands.xack(STREAM_KEY, CONSUMER_GROUP, message.getId());
                        return;
                    }

                    redisCommands.multi();
                    redisCommands.setex(dedupKey, DEDUP_TTL_SECONDS, "1");

                    TransactionResult result = redisCommands.exec();

                    if (result.wasDiscarded()) {
                        retries++;
                        Thread.sleep(10);
                        continue;
                    }

                    updateTotalDebtAtomic(userId, purchase);
                    updateHistoryAtomic(userId, purchase);
                    redisCommands.xack(STREAM_KEY, CONSUMER_GROUP, message.getId());
                    success = true;

                } catch (Exception e) {
                    redisCommands.discard();
                    retries++;
                    if (retries >= maxRetries) {
                        System.err.println("Failed to process message after " + maxRetries + " retries: " + e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
        }
    }

    private void updateTotalDebtAtomic(String userId, Purchase purchase) {
        String key = TOTAL_DEBT_PREFIX + userId;
        redisCommands.incrbyfloat(key, purchase.getTotal().doubleValue());
        totalDebtCache.remove(userId);
    }

    private void updateHistoryAtomic(String userId, Purchase purchase) {
        try {
            String key = HISTORY_PREFIX + userId;
            String purchaseJson = objectMapper.writeValueAsString(purchase);

            boolean success = false;
            int maxRetries = 100;
            int retries = 0;

            while (!success && retries < maxRetries) {
                try {
                    redisCommands.watch(key);

                    redisCommands.multi();
                    redisCommands.lpush(key, purchaseJson);
                    redisCommands.ltrim(key, 0, MAX_HISTORY - 1);

                    TransactionResult result = redisCommands.exec();

                    if (result.wasDiscarded()) {
                        retries++;
                        Thread.sleep(10);
                        continue;
                    }

                    historyCache.remove(userId);
                    success = true;

                } catch (Exception e) {
                    redisCommands.discard();
                    retries++;
                    if (retries >= maxRetries) {
                        throw e;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error updating history: " + e.getMessage());
        }
    }

    public BigDecimal getTotalDebt(String userId) {
        if (totalDebtCache.containsKey(userId)) {
            return totalDebtCache.get(userId);
        }

        String key = TOTAL_DEBT_PREFIX + userId;
        String total = redisCommands.get(key);
        BigDecimal debt = total != null ? new BigDecimal(total) : BigDecimal.ZERO;
        totalDebtCache.put(userId, debt);
        return debt;
    }

    public List<Purchase> getPurchaseHistory(String userId) {
        if (historyCache.containsKey(userId)) {
            return historyCache.get(userId);
        }

        try {
            String key = HISTORY_PREFIX + userId;
            List<String> purchaseJsonList = redisCommands.lrange(key, 0, -1);
            List<Purchase> purchases = new ArrayList<>();

            for (String purchaseJson : purchaseJsonList) {
                Purchase purchase = objectMapper.readValue(purchaseJson, Purchase.class);
                purchases.add(purchase);
            }

            Collections.reverse(purchases);
            historyCache.put(userId, purchases);
            return purchases;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
