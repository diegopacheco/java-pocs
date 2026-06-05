package com.slackclone.channel;

import java.time.Instant;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("channels")
public record Channel(
        @Id Long id,
        String name,
        String type,
        Long createdBy,
        Instant createdAt) {

    public static final String PUBLIC = "PUBLIC";
    public static final String PRIVATE = "PRIVATE";
    public static final String DIRECT = "DIRECT";
}
