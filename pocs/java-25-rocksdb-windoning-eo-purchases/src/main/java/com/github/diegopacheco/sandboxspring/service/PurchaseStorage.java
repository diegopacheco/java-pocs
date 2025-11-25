package com.github.diegopacheco.sandboxspring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.diegopacheco.sandboxspring.model.Purchase;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class PurchaseStorage {
    private final RocksDB dedupDatabase;
    private final ObjectMapper objectMapper;
    private final PurchaseProcessor processor;

    public PurchaseStorage(@Qualifier("dedupDatabase") RocksDB dedupDatabase, PurchaseProcessor processor) {
        this.dedupDatabase = dedupDatabase;
        this.objectMapper = new ObjectMapper();
        this.processor = processor;
    }

    public void storePurchase(Purchase purchase) {
        try {
            String purchaseId = purchase.getPurchaseId();
            byte[] key = purchaseId.getBytes(StandardCharsets.UTF_8);

            byte[] existing = dedupDatabase.get(key);
            if (existing != null) {
                return;
            }

            String message = objectMapper.writeValueAsString(purchase);
            dedupDatabase.put(key, message.getBytes(StandardCharsets.UTF_8));

            processor.processPurchase(purchase);
        } catch (RocksDBException | JsonProcessingException e) {
            throw new RuntimeException("Failed to store purchase", e);
        }
    }
}
