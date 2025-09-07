package com.github.diegopacheco.javapocs.codeorg.ddd.domain.transaction;

public enum TransactionType {
    CREDIT("credit"),
    DEBIT("debit");
    
    private final String value;
    
    TransactionType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public static TransactionType fromString(String value) {
        for (TransactionType type : TransactionType.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown transaction type: " + value);
    }
}