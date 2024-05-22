package com.github.diegopacheco.bookkeeping.events;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class RoomServiceOrderedEvent implements Event {

    private UUID userId;
    private String room;
    private BigDecimal total;
    private Instant timestamp;
    private String eventDescription;
    private String service;

    public RoomServiceOrderedEvent(UUID userId, String room, BigDecimal total, Instant timestamp,
                                   String eventDescription, String service) {
        this.userId = userId;
        this.room = room;
        this.total = total;
        this.timestamp = timestamp;
        this.eventDescription = eventDescription;
        this.service = service;
    }

    public UUID getUserId() {
        return userId;
    }
    public String getRoom() {
        return room;
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
    public String getService() {
        return service;
    }

    @Override
    public String toString() {
        return "RoomServiceOrderedEvent{" +
                "userId=" + userId +
                ", room='" + room + '\'' +
                ", total=" + total +
                ", timestamp=" + timestamp +
                ", eventDescription='" + eventDescription + '\'' +
                ", service='" + service + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomServiceOrderedEvent that = (RoomServiceOrderedEvent) o;
        return Objects.equals(userId, that.userId) && Objects.equals(room, that.room) && Objects.equals(total, that.total) && Objects.equals(timestamp, that.timestamp) && Objects.equals(eventDescription, that.eventDescription) && Objects.equals(service, that.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, room, total, timestamp, eventDescription, service);
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private UUID userId;
        private String room;
        private BigDecimal total;
        private Instant timestamp;
        private String eventDescription;
        private String service;

        public Builder withUserId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public Builder withRoom(String room) {
            this.room = room;
            return this;
        }

        public Builder withTotal(BigDecimal total) {
            this.total = total;
            return this;
        }

        public Builder withTimestamp(Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder withService(String service) {
            this.service = service;
            return this;
        }

        public Builder withEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
            return this;
        }

        public RoomServiceOrderedEvent build(){
            return new RoomServiceOrderedEvent(userId, room, total, timestamp, eventDescription,service);
        }
    }

}
