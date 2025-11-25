package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.model.Purchase;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PurchaseProcessor {
    private final PurchaseStorage purchaseStorage;

    public PurchaseProcessor(PurchaseStorage purchaseStorage) {
        this.purchaseStorage = purchaseStorage;
    }

    public BigDecimal getTotalDebt(String userId) {
        return purchaseStorage.getTotalDebt(userId);
    }

    public List<Purchase> getPurchaseHistory(String userId) {
        return purchaseStorage.getPurchaseHistory(userId);
    }
}
