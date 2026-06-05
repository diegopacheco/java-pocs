package com.slackclone.message;

import java.time.Instant;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table("messages")
public record Message(
        @Id Long id,
        Long channelId,
        Long userId,
        String content,
        Instant createdAt,
        Instant editedAt,
        @MappedCollection(idColumn = "message_id") Set<Attachment> attachments) {
}
