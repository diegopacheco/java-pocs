package com.github.diegopacheco.sandboxspring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.diegopacheco.sandboxspring.model.Purchase;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseProcessor {
    private static final int MAX_HISTORY = 20;
    private final RocksDB totalDebtDatabase;
    private final RocksDB historyDatabase;
    private final ObjectMapper objectMapper;

    public PurchaseProcessor(@Qualifier("totalDebtDatabase") RocksDB totalDebtDatabase,
                             @Qualifier("historyDatabase") RocksDB historyDatabase) {
        this.totalDebtDatabase = totalDebtDatabase;
        this.historyDatabase = historyDatabase;
        this.objectMapper = new ObjectMapper();
    }

    public void processPurchase(Purchase purchase) {
        try {
            updateTotalDebt(purchase);
            updateHistory(purchase);
        } catch (Exception e) {
            throw new RuntimeException("Failed to process purchase", e);
        }
    }

    private void updateTotalDebt(Purchase purchase) throws RocksDBException {
        String userId = purchase.getUserId();
        byte[] key = userId.getBytes(StandardCharsets.UTF_8);

        byte[] currentBytes = totalDebtDatabase.get(key);
        BigDecimal currentTotal = currentBytes != null
                ? new BigDecimal(new String(currentBytes, StandardCharsets.UTF_8))
                : BigDecimal.ZERO;

        BigDecimal newTotal = currentTotal.add(purchase.getTotal());
        totalDebtDatabase.put(key, newTotal.toString().getBytes(StandardCharsets.UTF_8));
    }

    private void updateHistory(Purchase purchase) throws Exception {
        String userId = purchase.getUserId();
        byte[] key = userId.getBytes(StandardCharsets.UTF_8);

        byte[] historyBytes = historyDatabase.get(key);
        List<String> history = historyBytes != null
                ? objectMapper.readValue(new String(historyBytes, StandardCharsets.UTF_8),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, String.class))
                : new ArrayList<>();

        String purchaseJson = objectMapper.writeValueAsString(purchase);
        history.add(purchaseJson);

        if (history.size() > MAX_HISTORY) {
            history.remove(0);
        }

        String updatedHistoryJson = objectMapper.writeValueAsString(history);
        historyDatabase.put(key, updatedHistoryJson.getBytes(StandardCharsets.UTF_8));
    }

    public BigDecimal getTotalDebt(String userId) {
        try {
            byte[] key = userId.getBytes(StandardCharsets.UTF_8);
            byte[] valueBytes = totalDebtDatabase.get(key);
            return valueBytes != null
                    ? new BigDecimal(new String(valueBytes, StandardCharsets.UTF_8))
                    : BigDecimal.ZERO;
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    public List<Purchase> getPurchaseHistory(String userId) {
        try {
            byte[] key = userId.getBytes(StandardCharsets.UTF_8);
            byte[] historyBytes = historyDatabase.get(key);

            if (historyBytes != null) {
                String historyJson = new String(historyBytes, StandardCharsets.UTF_8);
                List<String> purchaseJsonList = objectMapper.readValue(historyJson,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, String.class));

                List<Purchase> purchases = new ArrayList<>();
                for (String purchaseJson : purchaseJsonList) {
                    Purchase purchase = objectMapper.readValue(purchaseJson, Purchase.class);
                    purchases.add(purchase);
                }
                return purchases;
            }
            return new ArrayList<>();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
