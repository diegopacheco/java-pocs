package com.github.diegopacheco.javapocs.codeorg.ddd.domain.transaction;

import java.math.BigDecimal;
import java.util.Objects;

public record Amount(BigDecimal value) {
    
    public Amount {
        Objects.requireNonNull(value, "Amount cannot be null");
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }
    
    public static Amount of(BigDecimal value) {
        return new Amount(value);
    }
    
    public static Amount of(double value) {
        return new Amount(BigDecimal.valueOf(value));
    }
    
    public static Amount zero() {
        return new Amount(BigDecimal.ZERO);
    }
    
    public boolean isZero() {
        return value.compareTo(BigDecimal.ZERO) == 0;
    }
    
    public Amount add(Amount other) {
        return new Amount(value.add(other.value));
    }
    
    public Amount subtract(Amount other) {
        return new Amount(value.subtract(other.value));
    }
}