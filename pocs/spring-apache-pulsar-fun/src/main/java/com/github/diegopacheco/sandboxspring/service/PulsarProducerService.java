package com.github.diegopacheco.sandboxspring.service;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PulsarProducerService {

    @Autowired
    private PulsarClient pulsarClient;

    public void sendMessage(String topic, String message) {
        try (Producer<byte[]> producer = pulsarClient.newProducer()
                .topic(topic)
                .create()) {
            producer.send(message.getBytes());
            System.out.println("Message sent successfully: " + message);
        } catch (PulsarClientException e) {
            System.out.println("Failed to send message: " + e.getMessage());
            throw new RuntimeException("Failed to send message", e);
        }
    }
}