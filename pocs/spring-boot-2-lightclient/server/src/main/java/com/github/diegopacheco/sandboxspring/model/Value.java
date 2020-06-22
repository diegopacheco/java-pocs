package com.github.diegopacheco.sandboxspring.model;

import java.util.Objects;

public class Value {
    private Double result;

    public Value(){}

    public Value(Double result) {
        this.result = result;
    }

    public Double getResult() {
        return result;
    }
    public void setResult(Double result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value = (Value) o;
        return Objects.equals(getResult(), value.getResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResult());
    }

    @Override
    public String toString() {
        return "Value{" +
                "result=" + result +
                '}';
    }
}
