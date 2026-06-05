package com.slackclone.message;

public record AttachmentDto(Long id, String kind, String url, String mimeType, Long sizeBytes) {
}
