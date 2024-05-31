package com.github.diegopacheco.javapocs.suites;

import java.util.Objects;

public class Calculator {

    private Integer va;
    private Integer vb;

    public Calculator(Integer va, Integer vb) {
        this.va = va;
        this.vb = vb;
    }

    public Integer sum(){
        return va + vb;
    }

    public Integer sub(){
        return va - vb;
    }

    public Integer mul(){
        return va * vb;
    }

    public Integer div(){
        return va / vb;
    }

    public Integer mod(){
        return va % vb;
    }

    public Integer getVa() {
        return va;
    }

    public Integer getVb() {
        return vb;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(va, that.va) && Objects.equals(vb, that.vb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(va, vb);
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "va=" + va +
                ", vb=" + vb +
                '}';
    }
}
