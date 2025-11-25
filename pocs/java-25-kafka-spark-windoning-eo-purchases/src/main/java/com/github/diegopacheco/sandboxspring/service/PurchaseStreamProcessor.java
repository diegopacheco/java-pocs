package com.github.diegopacheco.sandboxspring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.diegopacheco.sandboxspring.model.Purchase;
import org.apache.spark.sql.*;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;

import static org.apache.spark.sql.functions.*;

@Service
public class PurchaseStreamProcessor {
    private static final int MAX_HISTORY = 20;
    private final ObjectMapper objectMapper;
    private final SparkSession spark;
    private final ConcurrentHashMap<String, BigDecimal> totalDebtCache;
    private final ConcurrentHashMap<String, List<Purchase>> historyCache;
    private StreamingQuery debtQuery;
    private StreamingQuery historyQuery;

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    public PurchaseStreamProcessor(SparkSession spark) {
        this.objectMapper = new ObjectMapper();
        this.spark = spark;
        this.totalDebtCache = new ConcurrentHashMap<>();
        this.historyCache = new ConcurrentHashMap<>();
    }

    @PostConstruct
    public void buildPipeline() {
        try {
            Dataset<Row> purchases = spark
                    .readStream()
                    .format("kafka")
                    .option("kafka.bootstrap.servers", bootstrapServers)
                    .option("subscribe", "purchases")
                    .option("startingOffsets", "earliest")
                    .option("kafka.isolation.level", "read_committed")
                    .load();

            Dataset<Row> parsedPurchases = purchases
                    .selectExpr("CAST(value AS STRING) as json_value")
                    .select(from_json(col("json_value"),
                            Encoders.bean(Purchase.class).schema()).as("purchase"))
                    .select("purchase.*");

            Dataset<Row> dedupedPurchases = parsedPurchases
                    .dropDuplicates("purchaseId");

            Dataset<Row> totalDebt = dedupedPurchases
                    .groupBy("userId")
                    .agg(sum("total").as("totalDebt"));

            debtQuery = totalDebt.writeStream()
                    .outputMode("complete")
                    .foreachBatch((batchDF, batchId) -> {
                        List<Row> rows = batchDF.collectAsList();
                        for (Row row : rows) {
                            String userId = row.getAs("userId");
                            Object totalDebtObj = row.getAs("totalDebt");
                            BigDecimal totalDebtValue = totalDebtObj != null ?
                                    new BigDecimal(totalDebtObj.toString()) : BigDecimal.ZERO;
                            totalDebtCache.put(userId, totalDebtValue);
                        }
                    })
                    .start();

            historyQuery = dedupedPurchases.writeStream()
                    .outputMode("append")
                    .foreachBatch((batchDF, batchId) -> {
                        List<Row> rows = batchDF.collectAsList();
                        for (Row row : rows) {
                            try {
                                Purchase purchase = new Purchase();
                                purchase.setPurchaseId(row.getAs("purchaseId"));
                                purchase.setUserId(row.getAs("userId"));
                                purchase.setProductName(row.getAs("productName"));
                                purchase.setProductType(row.getAs("productType"));

                                Object valueObj = row.getAs("value");
                                purchase.setValue(valueObj != null ? new BigDecimal(valueObj.toString()) : BigDecimal.ZERO);

                                Object quantityObj = row.getAs("quantity");
                                purchase.setQuantity(quantityObj != null ? (Integer) quantityObj : 0);

                                Object totalObj = row.getAs("total");
                                purchase.setTotal(totalObj != null ? new BigDecimal(totalObj.toString()) : BigDecimal.ZERO);

                                String userId = purchase.getUserId();
                                historyCache.compute(userId, (k, v) -> {
                                    List<Purchase> history = v != null ? v : new ArrayList<>();
                                    history.add(purchase);
                                    if (history.size() > MAX_HISTORY) {
                                        history.remove(0);
                                    }
                                    return history;
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    })
                    .start();

        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to start Spark streaming", e);
        }
    }

    @PreDestroy
    public void cleanup() {
        try {
            if (debtQuery != null) {
                debtQuery.stop();
            }
            if (historyQuery != null) {
                historyQuery.stop();
            }
        } catch (TimeoutException | IllegalStateException e) {
        }
    }

    public BigDecimal getTotalDebt(String userId) {
        return totalDebtCache.getOrDefault(userId, BigDecimal.ZERO);
    }

    public List<Purchase> getPurchaseHistory(String userId) {
        return historyCache.getOrDefault(userId, new ArrayList<>());
    }
}
