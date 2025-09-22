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
        new Thread(() -> {
            while (true) {
                try {
                    Consumer<byte[]> consumer = pulsarClient.newConsumer()
                            .topic("test-topic")
                            .subscriptionName("test-subscription")
                            .subscribe();

                    System.out.println("Pulsar consumer connected successfully!");

                    while (true) {
                        try {
                            Message<byte[]> message = consumer.receive();
                            String messageContent = new String(message.getData());
                            System.out.println("Received message: " + messageContent);
                            receivedMessages.add(messageContent);
                            consumer.acknowledge(message);
                        } catch (PulsarClientException e) {
                            System.out.println("Error receiving message: " + e.getMessage());
                            break;
                        }
                    }
                } catch (PulsarClientException e) {
                    System.out.println("Pulsar consumer failed to connect: " + e.getMessage() + ". Retrying in 5 seconds...");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }).start();
    }

    public List<String> getReceivedMessages() {
        return receivedMessages;
    }

    public void clearMessages() {
        receivedMessages.clear();
    }
}