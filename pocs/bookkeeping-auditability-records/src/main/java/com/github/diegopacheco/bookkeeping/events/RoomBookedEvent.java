package com.github.diegopacheco.bookkeeping.events;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class RoomBookedEvent implements Event {

    private UUID userId;
    private Integer numberOfNights;
    private String room;
    private BigDecimal total;
    private Instant timestamp;
    private String eventDescription;

    public RoomBookedEvent(UUID userId, Integer numberOfNights, String room, BigDecimal total, Instant timestamp, String eventDescription) {
        this.userId = userId;
        this.numberOfNights = numberOfNights;
        this.room = room;
        this.total = total;
        this.timestamp = timestamp;
        this.eventDescription = eventDescription;
    }

    public UUID getUserId() {
        return userId;
    }
    public Integer getNumberOfNights() {
        return numberOfNights;
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

    @Override
    public String toString() {
        return "RoomBookedEvent{" +
                "userId=" + userId +
                ", numberOfNights=" + numberOfNights +
                ", room='" + room + '\'' +
                ", total=" + total +
                ", timestamp=" + timestamp +
                ", eventDescription='" + eventDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomBookedEvent that = (RoomBookedEvent) o;
        return Objects.equals(userId, that.userId) && Objects.equals(numberOfNights, that.numberOfNights) && Objects.equals(room, that.room) && Objects.equals(total, that.total) && Objects.equals(timestamp, that.timestamp) && Objects.equals(eventDescription, that.eventDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, numberOfNights, room, total, timestamp, eventDescription);
    }

    public static RoomBookedEventBuilder builder() {
        return new RoomBookedEventBuilder();
    }

    public static class RoomBookedEventBuilder {
        private UUID userId;
        private Integer numberOfNights;
        private String room;
        private BigDecimal total;
        private Instant timestamp;
        private String eventDescription;

        public RoomBookedEventBuilder withUserId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public RoomBookedEventBuilder withNumberOfNights(Integer numberOfNights) {
            this.numberOfNights = numberOfNights;
            return this;
        }

        public RoomBookedEventBuilder withRoom(String room) {
            this.room = room;
            return this;
        }

        public RoomBookedEventBuilder withTotal(BigDecimal total) {
            this.total = total;
            return this;
        }

        public RoomBookedEventBuilder withTimestamp(Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public RoomBookedEventBuilder withEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
            return this;
        }

        public RoomBookedEvent build() {
            return new RoomBookedEvent(userId, numberOfNights, room, total, timestamp, eventDescription);
        }
    }

}
