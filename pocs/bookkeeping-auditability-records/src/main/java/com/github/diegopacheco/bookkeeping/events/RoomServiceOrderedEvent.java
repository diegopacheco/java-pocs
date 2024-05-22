package com.github.diegopacheco.bookkeeping.events;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class RoomServiceOrderedEvent {

    private UUID userId;
    private String room;
    private BigDecimal total;
    private Instant timestamp;
    private String eventDescription;

    public RoomServiceOrderedEvent(UUID userId, String room, BigDecimal total, Instant timestamp, String eventDescription) {
        this.userId = userId;
        this.room = room;
        this.total = total;
        this.timestamp = timestamp;
        this.eventDescription = eventDescription;
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

    @Override
    public String toString() {
        return "RoomServiceOrderedEvent{" +
                "userId=" + userId +
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
        RoomServiceOrderedEvent that = (RoomServiceOrderedEvent) o;
        return Objects.equals(userId, that.userId) && Objects.equals(room, that.room) && Objects.equals(total, that.total) && Objects.equals(timestamp, that.timestamp) && Objects.equals(eventDescription, that.eventDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, room, total, timestamp, eventDescription);
    }
}
