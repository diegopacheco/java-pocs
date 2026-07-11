package com.bookstore.security;

public class JwtException extends RuntimeException {
    public JwtException(String message) {
        super(message);
    }
}
