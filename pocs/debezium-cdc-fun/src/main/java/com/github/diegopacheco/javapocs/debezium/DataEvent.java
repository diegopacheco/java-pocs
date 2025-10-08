package com.github.diegopacheco.javapocs.debezium;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "data_events")
public class DataEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data;

    private LocalDateTime createdAt;

    public DataEvent() {
        this.createdAt = LocalDateTime.now();
    }

    public DataEvent(String data) {
        this.data = data;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
