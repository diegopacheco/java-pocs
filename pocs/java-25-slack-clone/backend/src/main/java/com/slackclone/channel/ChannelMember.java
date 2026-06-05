package com.slackclone.channel;

import java.time.Instant;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("channel_members")
public record ChannelMember(
        @Id Long id,
        Long channelId,
        Long userId,
        String role,
        Instant joinedAt) {

    public static final String OWNER = "OWNER";
    public static final String MEMBER = "MEMBER";
}
