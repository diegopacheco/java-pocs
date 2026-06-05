package com.slackclone.channel;

import com.slackclone.auth.AuthUser;
import java.time.Instant;

public record ChannelDto(
        Long id,
        String name,
        String type,
        Long createdBy,
        AuthUser counterpart,
        Instant createdAt) {
}
