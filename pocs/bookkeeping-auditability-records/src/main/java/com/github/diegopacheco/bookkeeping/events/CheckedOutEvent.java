package com.github.diegopacheco.bookkeeping.events;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class CheckedOutEvent implements Event {

    private UUID userId;
    private BigDecimal total;
    private Instant timestamp;
    private String eventDescription;
    private String room;

    public CheckedOutEvent(UUID userId, BigDecimal total, Instant timestamp, String eventDescription, String room) {
        this.userId = userId;
        this.total = total;
        this.timestamp = timestamp;
        this.eventDescription = eventDescription;
        this.room = room;
    }

    public UUID getUserId() {
        return userId;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public Instant getTimestamp() {
        return timestamp;
    }
    public String getEventDescription() {
        return eventDescription;
    }
    public String getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "CheckedOutEvent{" +
                "userId=" + userId +
                ", total=" + total +
                ", timestamp=" + timestamp +
                ", eventDescription='" + eventDescription + '\'' +
                ", room='" + room + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckedOutEvent that = (CheckedOutEvent) o;
        return Objects.equals(userId, that.userId) && Objects.equals(total, that.total) && Objects.equals(timestamp, that.timestamp) && Objects.equals(eventDescription, that.eventDescription) && Objects.equals(room, that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, total, timestamp, eventDescription, room);
    }

    public static CheckedOutEventBuilder builder() {
        return new CheckedOutEventBuilder();
    }

    public static class CheckedOutEventBuilder {
        private UUID userId;
        private BigDecimal total;
        private Instant timestamp;
        private String eventDescription;
        private String room;

        public CheckedOutEventBuilder withUserId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public CheckedOutEventBuilder withTotal(BigDecimal total) {
            this.total = total;
            return this;
        }

        public CheckedOutEventBuilder withTimestamp(Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public CheckedOutEventBuilder withEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
            return this;
        }

        public CheckedOutEventBuilder withRoom(String room) {
            this.room = room;
            return this;
        }

        public CheckedOutEvent build() {
            return new CheckedOutEvent(userId, total, timestamp, eventDescription, room);
        }
    }

}
