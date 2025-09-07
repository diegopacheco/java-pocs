package com.github.diegopacheco.javapocs.codeorg.ddd.domain.user;

import java.util.Objects;
import java.util.regex.Pattern;

public record Email(String value) {
    
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$");
    
    public Email {
        Objects.requireNonNull(value, "Email cannot be null");
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid email format: " + value);
        }
    }
    
    public static Email of(String value) {
        return new Email(value);
    }
}