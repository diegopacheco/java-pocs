package com.github.diegopacheco.javapocs.codeorg.ddd.domain.user;

public record Address(String value) {
    
    public Address {
        if (value != null && value.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty if provided");
        }
    }
    
    public static Address of(String value) {
        return new Address(value);
    }
    
    public boolean isEmpty() {
        return value == null || value.trim().isEmpty();
    }
}