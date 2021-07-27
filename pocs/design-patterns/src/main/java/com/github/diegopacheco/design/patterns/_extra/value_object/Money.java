package com.github.diegopacheco.design.patterns._extra.value_object;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private final BigDecimal value;

    public Money(BigDecimal value) {
        this.value = value;
    }

    public static Money valueOf(Double value){
        return new Money(BigDecimal.valueOf(value));
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                '}';
    }
}
