package com.github.diegopacheco.javapocs.codeorg.ddd.domain.preference;

public record SolVersion(String value) {
    
    public SolVersion {
        if (value != null && value.trim().isEmpty()) {
            throw new IllegalArgumentException("Sol version cannot be empty if provided");
        }
    }
    
    public static SolVersion of(String value) {
        return new SolVersion(value);
    }
    
    public boolean isEmpty() {
        return value == null || value.trim().isEmpty();
    }
}