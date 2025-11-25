package com.github.diegopacheco.sandboxspring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.diegopacheco.sandboxspring.model.Purchase;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PurchaseProducer {
    private final RedisCommands<String, String> redisCommands;
    private final ObjectMapper objectMapper;
    private static final String STREAM_KEY = "purchases";

    public PurchaseProducer(RedisCommands<String, String> redisCommands) {
        this.redisCommands = redisCommands;
        this.objectMapper = new ObjectMapper();
    }

    public void sendPurchase(Purchase purchase) {
        try {
            String message = objectMapper.writeValueAsString(purchase);
            Map<String, String> body = new HashMap<>();
            body.put("userId", purchase.getUserId());
            body.put("data", message);
            redisCommands.xadd(STREAM_KEY, body);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize purchase", e);
        }
    }
}
