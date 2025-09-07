package com.github.diegopacheco.javapocs.codeorg.ddd.domain.user;

import java.util.Objects;
import java.util.UUID;

public record UserId(String value) {
    
    public UserId {
        Objects.requireNonNull(value, "User ID cannot be null");
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be empty");
        }
    }
    
    public static UserId generate() {
        return new UserId(UUID.randomUUID().toString());
    }
    
    public static UserId of(String value) {
        return new UserId(value);
    }
}