package com.github.diegopacheco.javapocs.effectivejava3.staticfactory;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private BigDecimal value;

    private Money(){}

    private Money(Double initial){
        this.value = new BigDecimal(initial);
    }

    public static Money valueOf(Double initial){
        return new Money(initial);
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(getValue(), money.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                '}';
    }
}
