package com.github.diegopacheco.design.patterns.structural.bridge;

public class Main {
    public static void main(String[] args) {
        NotificationPublisher publisher = new TwitterPublisher();
        Notification twitterNotification = new TwitterNotification(publisher);
        twitterNotification.publish("Your wine arrived!");

        NotificationPublisher publisherSMS = new SMSPublisher();
        Notification smsNotification = new SMSNotification(publisherSMS);
        publisherSMS.publish("Your wine arrived!");
    }
}
