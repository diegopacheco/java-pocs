package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.model.Purchase;
import com.github.diegopacheco.sandboxspring.service.PurchaseProducer;
import com.github.diegopacheco.sandboxspring.service.PurchaseStreamProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class PurchaseController {
    private final PurchaseProducer purchaseProducer;
    private final PurchaseStreamProcessor purchaseStreamProcessor;
    private final Random random = new Random();

    private static final String[] PRODUCT_NAMES = {
            "Laptop", "Smartphone", "Headphones", "Keyboard", "Mouse",
            "Monitor", "Tablet", "Webcam", "Speaker", "Charger"
    };

    private static final String[] PRODUCT_TYPES = {
            "Electronics", "Accessories", "Computing", "Audio", "Display"
    };

    public PurchaseController(PurchaseProducer purchaseProducer, PurchaseStreamProcessor purchaseStreamProcessor) {
        this.purchaseProducer = purchaseProducer;
        this.purchaseStreamProcessor = purchaseStreamProcessor;
    }

    @GetMapping("/generate/{count}/{id}")
    public Map<String, Object> generate(@PathVariable int count, @PathVariable String id) {
        for (int i = 0; i < count; i++) {
            String productName = PRODUCT_NAMES[random.nextInt(PRODUCT_NAMES.length)];
            String productType = PRODUCT_TYPES[random.nextInt(PRODUCT_TYPES.length)];
            BigDecimal value = BigDecimal.valueOf(10 + random.nextDouble() * 990).setScale(2, RoundingMode.HALF_UP);
            int quantity = 1 + random.nextInt(5);

            Purchase purchase = new Purchase(id, productName, productType, value, quantity);
            purchaseProducer.sendPurchase(purchase);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("userId", id);
        response.put("purchasesGenerated", count);
        response.put("status", "success");
        return response;
    }

    @GetMapping("/total/{id}")
    public Map<String, Object> getTotal(@PathVariable String id) {
        BigDecimal total = purchaseStreamProcessor.getTotalDebt(id);
        Map<String, Object> response = new HashMap<>();
        response.put("userId", id);
        response.put("totalDebt", total);
        response.put("currency", "USD");
        return response;
    }

    @GetMapping("/duplicate/{count}/{id}")
    public Map<String, Object> duplicate(@PathVariable int count, @PathVariable String id) {
        BigDecimal totalDebt = purchaseStreamProcessor.getTotalDebt(id);

        if (totalDebt.compareTo(BigDecimal.ZERO) == 0) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "No purchases found for user");
            response.put("userId", id);
            return response;
        }

        String productName = PRODUCT_NAMES[0];
        String productType = PRODUCT_TYPES[0];
        BigDecimal value = BigDecimal.valueOf(50.00);
        int quantity = 2;

        for (int i = 0; i < count; i++) {
            Purchase purchase = new Purchase(id, productName, productType, value, quantity);
            purchaseProducer.sendPurchase(purchase);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("userId", id);
        response.put("duplicatesCreated", count);
        response.put("status", "success");
        return response;
    }

    @GetMapping("/history/{id}")
    public Map<String, Object> getHistory(@PathVariable String id) {
        List<Purchase> history = purchaseStreamProcessor.getPurchaseHistory(id);
        Map<String, Object> response = new HashMap<>();
        response.put("userId", id);
        response.put("purchaseCount", history.size());
        response.put("purchases", history);
        return response;
    }
}
