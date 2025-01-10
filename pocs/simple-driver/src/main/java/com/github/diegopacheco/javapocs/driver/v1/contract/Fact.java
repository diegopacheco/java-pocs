package com.github.diegopacheco.javapocs.driver.v1.contract;

import java.util.Objects;

public class Fact {

    private String fact;

    public Fact(){}

    public Fact(String value){
        this.fact = value;
    }

    public String getValue() {
        return fact;
    }
    public void setValue(String value) {
        this.fact = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Fact fact = (Fact) o;
        return Objects.equals(this.fact, fact.fact);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fact);
    }

    @Override
    public String toString() {
        return "Fact{" +
                "value='" + fact + '\'' +
                '}';
    }
}
