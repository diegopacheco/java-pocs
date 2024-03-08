package com.github.diegopacheco.pocs.java.webflux.client;

import java.util.Objects;

public class Fact {

    private String fact;
    private Integer length;

    public Fact(){}
    public Fact(String fact, Integer length) {
        this.fact = fact;
        this.length = length;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getFact() {
        return fact;
    }

    public Integer getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fact fact1 = (Fact) o;
        return Objects.equals(fact, fact1.fact) && Objects.equals(length, fact1.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fact, length);
    }
}
