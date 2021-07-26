package com.github.diegopacheco.design.patterns.structural.bridge;

public class TwitterPublisher implements NotificationPublisher {
    @Override
    public void publish(String message) {
        // Add real twitter implementation
        System.out.println("Publishing into twitter... [" + message + "]");
    }
}
