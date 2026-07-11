package com.bookstore.web.dto;

public record TokenResponse(String token, long expiresInSeconds) {
}
