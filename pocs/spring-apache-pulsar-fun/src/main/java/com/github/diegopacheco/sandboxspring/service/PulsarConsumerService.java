package com.github.diegopacheco.sandboxspring.service;

import org.apache.pulsar.client.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

@Service
public class PulsarConsumerService {

    @Autowired
    private PulsarClient pulsarClient;

    private final List<String> receivedMessages = new CopyOnWriteArrayList<>();

    @PostConstruct
    public void init() {
        try {
            Consumer<byte[]> consumer = pulsarClient.newConsumer()
                    .topic("test-topic")
                    .subscriptionName("test-subscription")
                    .subscribe();

            new Thread(() -> {
                while (true) {
                    try {
                        Message<byte[]> message = consumer.receive();
                        String messageContent = new String(message.getData());
                        System.out.println("Received message: " + messageContent);
                        receivedMessages.add(messageContent);
                        consumer.acknowledge(message);
                    } catch (PulsarClientException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (PulsarClientException e) {
            throw new RuntimeException("Failed to create consumer", e);
        }
    }

    public List<String> getReceivedMessages() {
        return receivedMessages;
    }

    public void clearMessages() {
        receivedMessages.clear();
    }
}