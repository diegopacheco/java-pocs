package com.slackclone.notification;

import java.time.Instant;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("notifications")
public record Notification(
        @Id Long id,
        Long userId,
        Long messageId,
        String kind,
        boolean isRead,
        Instant createdAt) {

    public static final String MENTION = "MENTION";
    public static final String DIRECT_MESSAGE = "DIRECT_MESSAGE";
}
