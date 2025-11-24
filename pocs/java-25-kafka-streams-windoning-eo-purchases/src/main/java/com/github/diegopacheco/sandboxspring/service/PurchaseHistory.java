package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.model.Purchase;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PurchaseHistory {
    private final Map<String, List<Purchase>> userPurchases = new ConcurrentHashMap<>();
    private static final int MAX_HISTORY = 20;

    public void addPurchase(Purchase purchase) {
        userPurchases.computeIfAbsent(purchase.getUserId(), k -> new ArrayList<>());
        List<Purchase> purchases = userPurchases.get(purchase.getUserId());
        purchases.add(purchase);
        if (purchases.size() > MAX_HISTORY) {
            purchases.remove(0);
        }
    }

    public List<Purchase> getHistory(String userId) {
        return userPurchases.getOrDefault(userId, new ArrayList<>());
    }
}
