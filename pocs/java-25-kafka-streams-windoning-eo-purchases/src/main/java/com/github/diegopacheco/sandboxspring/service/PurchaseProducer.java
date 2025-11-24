package com.github.diegopacheco.sandboxspring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.diegopacheco.sandboxspring.model.Purchase;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PurchaseProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private static final String TOPIC = "purchases";

    public PurchaseProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = new ObjectMapper();
    }

    public void sendPurchase(Purchase purchase) {
        try {
            String message = objectMapper.writeValueAsString(purchase);
            kafkaTemplate.send(TOPIC, purchase.getUserId(), message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize purchase", e);
        }
    }
}
