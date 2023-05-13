package com.github.diegopacheco.javapocs.filter;

import java.util.Objects;

public class HitEvent {

    private String path;
    private long timestamp;

    public HitEvent(String path,long timestamp){
        this.path = path;
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HitEvent hitEvent = (HitEvent) o;
        return timestamp == hitEvent.timestamp && Objects.equals(path, hitEvent.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, timestamp);
    }

    @Override
    public String toString() {
        return "HitEvent{" +
                "path='" + path + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
