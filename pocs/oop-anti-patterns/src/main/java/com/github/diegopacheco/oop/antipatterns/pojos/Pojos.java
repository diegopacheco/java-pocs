package com.github.diegopacheco.oop.antipatterns.pojos;

import java.util.Objects;

/**
 * POJOs
 *
 *  - Because of Getters/Setters, we force the logic to the consumer.
 *  - Can easy lead to code duplication.
 *  - Are not proper abstractions.
 *
 */
public class Pojos {

    // provider
    public class UserData{
        private String defaultEmailClient;

        public UserData() {}

        public UserData(String defaultEmailClient) {
            this.defaultEmailClient = defaultEmailClient;
        }

        public String getDefaultEmailClient() {
            return defaultEmailClient;
        }

        public void setDefaultEmailClient(String defaultEmailClient) {
            this.defaultEmailClient = defaultEmailClient;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            UserData userData = (UserData) o;
            return Objects.equals(defaultEmailClient, userData.defaultEmailClient);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(defaultEmailClient);
        }

        @Override
        public String toString() {
            return "UserData{" +
                    "defaultEmailClient='" + defaultEmailClient + '\'' +
                    '}';
        }
    }

    // consumer
    public class NotificationService {
        public void sendNotification(UserData userData) {
            System.out.println("Sending notification to user with email client: " + userData.getDefaultEmailClient());
            // logic to send email here.
        }
    }

}