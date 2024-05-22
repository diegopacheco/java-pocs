package com.github.diegopacheco.bookkeeping.events;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class SignUpEvent implements Event {

    private UUID userId;
    private Instant timestamp;
    private String eventDescription;

    public SignUpEvent(UUID userId, Instant timestamp, String eventDescription) {
        this.userId = userId;
        this.timestamp = timestamp;
        this.eventDescription = eventDescription;
    }

    public UUID getUserId() {
        return userId;
    }
    public Instant getTimestamp() {
        return timestamp;
    }
    public String getEventDescription() {
        return eventDescription;
    }

    @Override
    public String toString() {
        return "SignUpEvent{" +
                "userId=" + userId +
                ", timestamp=" + timestamp +
                ", eventDescription='" + eventDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignUpEvent that = (SignUpEvent) o;
        return Objects.equals(userId, that.userId) && Objects.equals(timestamp, that.timestamp) && Objects.equals(eventDescription, that.eventDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, timestamp, eventDescription);
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private UUID userId;
        private Instant timestamp;
        private String eventDescription;

        public Builder withUserId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public Builder withTimestamp(Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder withEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
            return this;
        }

        public SignUpEvent build() {
            return new SignUpEvent(userId, timestamp, eventDescription);
        }
    }
}
