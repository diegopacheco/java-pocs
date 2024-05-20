package com.github.diegopacheco.bookkeeping;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class Entry{
    private UUID id;
    private String event;
    private Instant timestamp;

    public Entry(UUID id,String event) {
        this.id = id;
        this.timestamp = Instant.now();
        this.event = event;
    }

    public Entry(String event) {
        this.id = UUID.randomUUID();
        this.timestamp = Instant.now();
        this.event = event;
    }

    public Entry(UUID id, String event, Instant timestamp) {
        this.id = id;
        this.event = event;
        this.timestamp = timestamp;
    }

    public UUID getId() {
        return id;
    }
    public String getEvent() {
        return event;
    }
    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(id, entry.id) && Objects.equals(event, entry.event) && Objects.equals(timestamp, entry.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, event, timestamp);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", event='" + event + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}