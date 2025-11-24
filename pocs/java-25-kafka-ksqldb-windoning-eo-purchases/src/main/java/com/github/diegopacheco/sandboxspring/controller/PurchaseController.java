package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.model.Purchase;
import com.github.diegopacheco.sandboxspring.service.PurchaseProducer;
import com.github.diegopacheco.sandboxspring.service.KsqlDbQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@RestController
public class PurchaseController {
    private final PurchaseProducer purchaseProducer;
    private final KsqlDbQueryService ksqlDbQueryService;
    private final Random random = new Random();

    private static final String[] PRODUCT_NAMES = {
            "Laptop", "Smartphone", "Headphones", "Keyboard", "Mouse",
            "Monitor", "Tablet", "Webcam", "Speaker", "Charger"
    };

    private static final String[] PRODUCT_TYPES = {
            "Electronics", "Accessories", "Computing", "Audio", "Display"
    };

    public PurchaseController(PurchaseProducer purchaseProducer, KsqlDbQueryService ksqlDbQueryService) {
        this.purchaseProducer = purchaseProducer;
        this.ksqlDbQueryService = ksqlDbQueryService;
    }

    @GetMapping("/generate/{count}/{id}")
    public Map<String, Object> generate(@PathVariable int count, @PathVariable String id) {
        for (int i = 0; i < count; i++) {
            String productName = PRODUCT_NAMES[random.nextInt(PRODUCT_NAMES.length)];
            String productType = PRODUCT_TYPES[random.nextInt(PRODUCT_TYPES.length)];
            BigDecimal value = BigDecimal.valueOf(10 + random.nextDouble() * 990).setScale(2, RoundingMode.HALF_UP);
            int quantity = 1 + random.nextInt(5);

            String purchaseId = generateDeterministicPurchaseId(id, productName, value, quantity);

            Purchase purchase = new Purchase(purchaseId, id, productName, productType, value, quantity);
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
        BigDecimal total = ksqlDbQueryService.getTotalDebt(id);
        Map<String, Object> response = new HashMap<>();
        response.put("userId", id);
        response.put("totalDebt", total);
        response.put("currency", "USD");
        return response;
    }

    @GetMapping("/duplicate/{count}/{id}")
    public Map<String, Object> duplicate(@PathVariable int count, @PathVariable String id) {
        String purchaseId = UUID.randomUUID().toString();
        String productName = PRODUCT_NAMES[0];
        String productType = PRODUCT_TYPES[0];
        BigDecimal value = BigDecimal.valueOf(50.00);
        int quantity = 2;

        for (int i = 0; i < count; i++) {
            Purchase purchase = new Purchase(purchaseId, id, productName, productType, value, quantity);
            purchaseProducer.sendPurchase(purchase);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("userId", id);
        response.put("purchaseId", purchaseId);
        response.put("duplicatesSent", count);
        response.put("status", "success");
        response.put("note", "All duplicates use same purchaseId - only 1 will be processed");
        return response;
    }

    @GetMapping("/history/{id}")
    public Map<String, Object> getHistory(@PathVariable String id) {
        List<Purchase> history = ksqlDbQueryService.getPurchaseHistory(id);
        Map<String, Object> response = new HashMap<>();
        response.put("userId", id);
        response.put("purchaseCount", history.size());
        response.put("purchases", history);
        return response;
    }

    @GetMapping("/idempotent-test/{userId}/{product}/{value}/{qty}")
    public Map<String, Object> idempotentTest(@PathVariable String userId,
                                               @PathVariable String product,
                                               @PathVariable BigDecimal value,
                                               @PathVariable int qty) {
        String purchaseId = generateDeterministicPurchaseId(userId, product, value, qty);
        BigDecimal total = value.multiply(BigDecimal.valueOf(qty));

        Purchase purchase = new Purchase(purchaseId, userId, product, "Test", value, qty);
        purchaseProducer.sendPurchase(purchase);

        Map<String, Object> response = new HashMap<>();
        response.put("userId", userId);
        response.put("purchaseId", purchaseId);
        response.put("product", product);
        response.put("value", value);
        response.put("quantity", qty);
        response.put("total", total);
        response.put("note", "Same parameters will generate same purchaseId - deduplication happens in ksqlDB");
        return response;
    }

    private String generateDeterministicPurchaseId(String userId, String productName, BigDecimal value, int quantity) {
        String composite = userId + "-" + productName + "-" + value.toPlainString() + "-" + quantity;
        return UUID.nameUUIDFromBytes(composite.getBytes()).toString();
    }
}
