package com.github.diegopacheco.javapocs.codeorg.ddd.domain.preference;

import java.util.Objects;
import java.util.UUID;

public record PreferenceId(String value) {
    
    public PreferenceId {
        Objects.requireNonNull(value, "Preference ID cannot be null");
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("Preference ID cannot be empty");
        }
    }
    
    public static PreferenceId generate() {
        return new PreferenceId(UUID.randomUUID().toString());
    }
    
    public static PreferenceId of(String value) {
        return new PreferenceId(value);
    }
}