package com.github.diegopacheco.design.patterns.structural.bridge;

public class SMSNotification extends Notification {

    public SMSNotification(NotificationPublisher publisher){
        super(publisher);
    }

    @Override
    public void publish(String message) {
        publisher.publish(message);
    }
}
