package com.github.diegopacheco.bookkeeping.events;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class DailyFeeEvent {

    private UUID userId;
    private BigDecimal value;
    private Instant timestamp;
    private String eventDescription;

    public DailyFeeEvent(UUID userId, BigDecimal value, Instant timestamp, String eventDescription) {
        this.userId = userId;
        this.value = value;
        this.timestamp = timestamp;
        this.eventDescription = eventDescription;
    }

    public UUID getUserId() {
        return userId;
    }
    public BigDecimal getValue() {
        return value;
    }
    public Instant getTimestamp() {
        return timestamp;
    }
    public String getEventDescription() {
        return eventDescription;
    }

    @Override
    public String toString() {
        return "DailyFeeEvent{" +
                "userId=" + userId +
                ", value=" + value +
                ", timestamp=" + timestamp +
                ", eventDescription='" + eventDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyFeeEvent that = (DailyFeeEvent) o;
        return Objects.equals(userId, that.userId) && Objects.equals(value, that.value) && Objects.equals(timestamp, that.timestamp) && Objects.equals(eventDescription, that.eventDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, value, timestamp, eventDescription);
    }

    public static DailyFeeEventBuilder builder() {
        return new DailyFeeEventBuilder();
    }

    public static class DailyFeeEventBuilder {
        private UUID userId;
        private BigDecimal value;
        private Instant timestamp;
        private String eventDescription;

        public DailyFeeEventBuilder withUserId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public DailyFeeEventBuilder withValue(BigDecimal value) {
            this.value = value;
            return this;
        }

        public DailyFeeEventBuilder withTimestamp(Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public DailyFeeEventBuilder withEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
            return this;
        }

        public DailyFeeEvent build() {
            return new DailyFeeEvent(userId, value, timestamp, eventDescription);
        }
    }

}
