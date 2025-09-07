package com.github.diegopacheco.javapocs.codeorg.ddd.domain.transaction;

import java.util.Objects;
import java.util.UUID;

public record TransactionId(String value) {
    
    public TransactionId {
        Objects.requireNonNull(value, "Transaction ID cannot be null");
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("Transaction ID cannot be empty");
        }
    }
    
    public static TransactionId generate() {
        return new TransactionId(UUID.randomUUID().toString());
    }
    
    public static TransactionId of(String value) {
        return new TransactionId(value);
    }
}