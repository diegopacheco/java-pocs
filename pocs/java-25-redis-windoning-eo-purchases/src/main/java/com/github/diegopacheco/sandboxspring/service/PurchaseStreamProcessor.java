package com.github.diegopacheco.sandboxspring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.diegopacheco.sandboxspring.model.Purchase;
import io.lettuce.core.StreamMessage;
import io.lettuce.core.XReadArgs;
import io.lettuce.core.api.sync.RedisCommands;
import jakarta.annotation.PostConstruct;
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
    private static final String TOTAL_DEBT_PREFIX = "total:";
    private static final String HISTORY_PREFIX = "history:";
    private static final String DEDUP_PREFIX = "dedup:";
    private static final int MAX_HISTORY = 20;

    private final RedisCommands<String, String> redisCommands;
    private final ObjectMapper objectMapper;
    private final Map<String, BigDecimal> totalDebtCache;
    private final Map<String, List<Purchase>> historyCache;

    public PurchaseStreamProcessor(RedisCommands<String, String> redisCommands) {
        this.redisCommands = redisCommands;
        this.objectMapper = new ObjectMapper();
        this.totalDebtCache = new ConcurrentHashMap<>();
        this.historyCache = new ConcurrentHashMap<>();
    }

    @PostConstruct
    public void startProcessing() {
        Thread processorThread = new Thread(() -> {
            String lastId = "0-0";
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    List<StreamMessage<String, String>> messages = redisCommands.xread(
                            XReadArgs.StreamOffset.from(STREAM_KEY, lastId)
                    );

                    for (StreamMessage<String, String> message : messages) {
                        processMessage(message);
                        lastId = message.getId();
                    }

                    if (messages.isEmpty()) {
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

    private void processMessage(StreamMessage<String, String> message) {
        try {
            Map<String, String> body = message.getBody();
            String userId = body.get("userId");
            String purchaseJson = body.get("data");

            Purchase purchase = objectMapper.readValue(purchaseJson, Purchase.class);
            String purchaseId = purchase.getPurchaseId();

            String dedupKey = DEDUP_PREFIX + purchaseId;
            Boolean dedup = redisCommands.setnx(dedupKey, "1");

            if (Boolean.TRUE.equals(dedup)) {
                updateTotalDebt(userId, purchase);
                updateHistory(userId, purchase);
            }
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
        }
    }

    private void updateTotalDebt(String userId, Purchase purchase) {
        String key = TOTAL_DEBT_PREFIX + userId;
        String currentTotal = redisCommands.get(key);
        BigDecimal total = currentTotal != null ? new BigDecimal(currentTotal) : BigDecimal.ZERO;
        total = total.add(purchase.getTotal());
        redisCommands.set(key, total.toString());
        totalDebtCache.put(userId, total);
    }

    private void updateHistory(String userId, Purchase purchase) {
        try {
            String key = HISTORY_PREFIX + userId;
            String purchaseJson = objectMapper.writeValueAsString(purchase);
            redisCommands.lpush(key, purchaseJson);
            redisCommands.ltrim(key, 0, MAX_HISTORY - 1);
            historyCache.remove(userId);
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
