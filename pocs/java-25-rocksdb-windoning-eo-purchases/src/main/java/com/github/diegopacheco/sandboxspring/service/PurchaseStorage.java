package com.github.diegopacheco.sandboxspring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.diegopacheco.sandboxspring.model.Purchase;
import org.rocksdb.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseStorage {
    private static final int MAX_HISTORY = 20;
    private final TransactionDB transactionDB;
    private final ColumnFamilyHandle dedupCF;
    private final ColumnFamilyHandle totalDebtCF;
    private final ColumnFamilyHandle historyCF;
    private final ObjectMapper objectMapper;

    public PurchaseStorage(TransactionDB transactionDB,
                          @Qualifier("dedupColumnFamily") ColumnFamilyHandle dedupCF,
                          @Qualifier("totalDebtColumnFamily") ColumnFamilyHandle totalDebtCF,
                          @Qualifier("historyColumnFamily") ColumnFamilyHandle historyCF) {
        this.transactionDB = transactionDB;
        this.dedupCF = dedupCF;
        this.totalDebtCF = totalDebtCF;
        this.historyCF = historyCF;
        this.objectMapper = new ObjectMapper();
    }

    public void storePurchase(Purchase purchase) {
        Transaction txn = null;
        try (WriteOptions writeOptions = new WriteOptions().setSync(true);
             ReadOptions readOptions = new ReadOptions()) {

            txn = transactionDB.beginTransaction(writeOptions);

            String purchaseId = purchase.getPurchaseId();
            byte[] purchaseKey = purchaseId.getBytes(StandardCharsets.UTF_8);

            byte[] existing = txn.get(dedupCF, readOptions, purchaseKey);
            if (existing != null) {
                txn.rollback();
                return;
            }

            String purchaseJson = objectMapper.writeValueAsString(purchase);
            txn.put(dedupCF, purchaseKey, purchaseJson.getBytes(StandardCharsets.UTF_8));

            String userId = purchase.getUserId();
            byte[] userKey = userId.getBytes(StandardCharsets.UTF_8);

            byte[] currentTotalBytes = txn.get(totalDebtCF, readOptions, userKey);
            BigDecimal currentTotal = currentTotalBytes != null
                    ? new BigDecimal(new String(currentTotalBytes, StandardCharsets.UTF_8))
                    : BigDecimal.ZERO;

            BigDecimal newTotal = currentTotal.add(purchase.getTotal());
            txn.put(totalDebtCF, userKey, newTotal.toString().getBytes(StandardCharsets.UTF_8));

            byte[] historyBytes = txn.get(historyCF, readOptions, userKey);
            List<String> history = historyBytes != null
                    ? objectMapper.readValue(new String(historyBytes, StandardCharsets.UTF_8),
                        objectMapper.getTypeFactory().constructCollectionType(List.class, String.class))
                    : new ArrayList<>();

            history.add(purchaseJson);
            if (history.size() > MAX_HISTORY) {
                history.remove(0);
            }

            String updatedHistoryJson = objectMapper.writeValueAsString(history);
            txn.put(historyCF, userKey, updatedHistoryJson.getBytes(StandardCharsets.UTF_8));

            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                try {
                    txn.rollback();
                } catch (RocksDBException ex) {
                }
            }
            throw new RuntimeException("Failed to store purchase", e);
        }
    }

    public BigDecimal getTotalDebt(String userId) {
        try (ReadOptions readOptions = new ReadOptions()) {
            byte[] key = userId.getBytes(StandardCharsets.UTF_8);
            byte[] valueBytes = transactionDB.get(totalDebtCF, readOptions, key);
            return valueBytes != null
                    ? new BigDecimal(new String(valueBytes, StandardCharsets.UTF_8))
                    : BigDecimal.ZERO;
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    public List<Purchase> getPurchaseHistory(String userId) {
        try (ReadOptions readOptions = new ReadOptions()) {
            byte[] key = userId.getBytes(StandardCharsets.UTF_8);
            byte[] historyBytes = transactionDB.get(historyCF, readOptions, key);

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
