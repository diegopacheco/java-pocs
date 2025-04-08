package com.github.diegopacheco.liquidunit.parser;

public record SQLAssertionPair(String sql, Integer expectedValue) {
    @Override
    public String toString() {
        return "SQLAssertionPair{" +
                "sql='" + sql + '\'' +
                ", expectedValue=" + expectedValue +
                '}';
    }
}
