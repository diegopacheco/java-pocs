package com.github.diegopacheco.design.patterns.structural.bridge;

// Bridge: Notification and Notification Publisher
public abstract class Notification {
    protected NotificationPublisher publisher;

    public Notification(NotificationPublisher publisher){
        this.publisher = publisher;
    }

    abstract public void publish(String message);

}
