package com.slackclone.auth;

import java.time.Instant;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("sessions")
public record Session(
        @Id Long id,
        String token,
        Long userId,
        Instant createdAt) {
}
