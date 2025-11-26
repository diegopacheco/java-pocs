package com.github.diegopacheco.sandboxspring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.diegopacheco.sandboxspring.model.Purchase;
import org.apache.flink.api.common.ExecutionConfig;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.common.state.MapState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PurchaseStreamProcessor {
    private static final int MAX_HISTORY = 20;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Map<String, BigDecimal> totalDebtStore = new ConcurrentHashMap<>();
    private final Map<String, List<Purchase>> historyStore = new ConcurrentHashMap<>();
    private final Map<String, Purchase> dedupStore = new ConcurrentHashMap<>();

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    private StreamExecutionEnvironment env;

    @PostConstruct
    public void init() {
        env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        ExecutionConfig config = env.getConfig();
        config.setAutoWatermarkInterval(1000);

        new Thread(() -> {
            try {
                buildPipeline();
                env.execute("Purchase Processing Job");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void buildPipeline() throws Exception {
        KafkaSource<String> source = KafkaSource.<String>builder()
                .setBootstrapServers(bootstrapServers)
                .setTopics("purchases")
                .setGroupId("purchase-flink-group")
                .setStartingOffsets(OffsetsInitializer.earliest())
                .setValueOnlyDeserializer(new org.apache.flink.api.common.serialization.SimpleStringSchema())
                .build();

        DataStream<String> purchases = env
                .fromSource(source, WatermarkStrategy.noWatermarks(), "Kafka Source");

        DataStream<Purchase> parsedPurchases = purchases
                .map(json -> objectMapper.readValue(json, Purchase.class))
                .returns(Purchase.class);

        DataStream<Purchase> dedupedPurchases = parsedPurchases
                .keyBy(Purchase::getPurchaseId)
                .map(new DeduplicationFunction());

        dedupedPurchases
                .keyBy(Purchase::getUserId)
                .map(new TotalDebtFunction(totalDebtStore, historyStore));
    }

    public static class DeduplicationFunction extends RichMapFunction<Purchase, Purchase> {
        private transient MapState<String, Boolean> seenPurchases;

        @Override
        public void open(Configuration parameters) {
            MapStateDescriptor<String, Boolean> descriptor = new MapStateDescriptor<>(
                    "dedup-state",
                    TypeInformation.of(String.class),
                    TypeInformation.of(Boolean.class)
            );
            seenPurchases = getRuntimeContext().getMapState(descriptor);
        }

        @Override
        public Purchase map(Purchase purchase) throws Exception {
            if (!seenPurchases.contains(purchase.getPurchaseId())) {
                seenPurchases.put(purchase.getPurchaseId(), true);
                return purchase;
            }
            return null;
        }
    }

    public static class TotalDebtFunction extends RichMapFunction<Purchase, Purchase> {
        private transient ValueState<BigDecimal> totalDebtState;
        private transient MapState<String, Purchase> historyState;
        private final Map<String, BigDecimal> totalDebtStore;
        private final Map<String, List<Purchase>> historyStore;

        public TotalDebtFunction(Map<String, BigDecimal> totalDebtStore, Map<String, List<Purchase>> historyStore) {
            this.totalDebtStore = totalDebtStore;
            this.historyStore = historyStore;
        }

        @Override
        public void open(Configuration parameters) {
            ValueStateDescriptor<BigDecimal> totalDescriptor = new ValueStateDescriptor<>(
                    "total-debt-state",
                    TypeInformation.of(BigDecimal.class)
            );
            totalDebtState = getRuntimeContext().getState(totalDescriptor);

            MapStateDescriptor<String, Purchase> historyDescriptor = new MapStateDescriptor<>(
                    "history-state",
                    TypeInformation.of(String.class),
                    TypeInformation.of(Purchase.class)
            );
            historyState = getRuntimeContext().getMapState(historyDescriptor);
        }

        @Override
        public Purchase map(Purchase purchase) throws Exception {
            if (purchase == null) return null;

            BigDecimal currentTotal = totalDebtState.value();
            if (currentTotal == null) {
                currentTotal = BigDecimal.ZERO;
            }
            BigDecimal newTotal = currentTotal.add(purchase.getTotal());
            totalDebtState.update(newTotal);
            totalDebtStore.put(purchase.getUserId(), newTotal);

            historyState.put(UUID.randomUUID().toString(), purchase);
            List<Purchase> history = new ArrayList<>();
            for (Purchase p : historyState.values()) {
                history.add(p);
            }
            if (history.size() > MAX_HISTORY) {
                Iterator<Map.Entry<String, Purchase>> iterator = historyState.entries().iterator();
                if (iterator.hasNext()) {
                    String keyToRemove = iterator.next().getKey();
                    historyState.remove(keyToRemove);
                    history.remove(0);
                }
            }
            historyStore.put(purchase.getUserId(), new ArrayList<>(history));

            return purchase;
        }
    }

    public BigDecimal getTotalDebt(String userId) {
        return totalDebtStore.getOrDefault(userId, BigDecimal.ZERO);
    }

    public List<Purchase> getPurchaseHistory(String userId) {
        return historyStore.getOrDefault(userId, new ArrayList<>());
    }
}
