package com.github.diegopacheco.design.patterns.structural.bridge;

public class SMSPublisher implements NotificationPublisher{
    @Override
    public void publish(String message) {
        // add real SMS publishing...
        System.out.println("Publishing SMS... [" + message + "]");
    }
}
