package com.github.diegopacheco.design.patterns.structural.bridge;

public class TwitterNotification extends Notification {

    public TwitterNotification(NotificationPublisher publisher){
        super(publisher);
    }

    @Override
    public void publish(String message) {
        publisher.publish(message);
    }
}
