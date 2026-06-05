package com.slackclone.user;

import java.time.Instant;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public record User(
        @Id Long id,
        String username,
        String passwordHash,
        String displayName,
        String avatarUrl,
        Instant createdAt) {
}
