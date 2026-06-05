package com.slackclone.auth;

public record AuthResponse(String token, AuthUser user) {
}
