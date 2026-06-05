package com.slackclone.notification;

import com.slackclone.auth.AuthUser;
import java.time.Instant;

public record NotificationDto(
        Long id,
        String kind,
        boolean isRead,
        Long channelId,
        Long messageId,
        AuthUser actor,
        String snippet,
        Instant createdAt) {
}
