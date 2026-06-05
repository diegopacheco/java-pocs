package com.slackclone.message;

public record AttachmentInput(String kind, String url, String mimeType, Long sizeBytes) {
}
