package com.github.diegopacheco.sandboxspring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

@Table("audit")
public class Audit {
    @Id
    private Integer id;
    private LocalDateTime timestamp;
    private String event;
    private String userId;

    public Audit() {}

    public Audit(String event, String userId) {
        this.event = event;
        this.userId = userId;
        this.timestamp = LocalDateTime.now();
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getEvent() { return event; }
    public void setEvent(String event) { this.event = event; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
}