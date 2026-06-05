package com.slackclone.message;

import com.slackclone.auth.AuthUser;
import java.time.Instant;
import java.util.List;

public record MessageDto(
        Long id,
        Long channelId,
        AuthUser author,
        String content,
        Instant createdAt,
        Instant editedAt,
        List<AttachmentDto> attachments) {
}
