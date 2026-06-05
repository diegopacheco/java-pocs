package com.slackclone.message;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("attachments")
public record Attachment(
        @Id Long id,
        String kind,
        String url,
        String mimeType,
        Long sizeBytes) {

    public static final String IMAGE = "IMAGE";
    public static final String GIF = "GIF";
    public static final String YOUTUBE = "YOUTUBE";
}
