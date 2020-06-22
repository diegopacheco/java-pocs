package com.github.diegopacheco.sandboxspring.model;

import java.util.Objects;

public class Op {
    private Double va;
    private Double vb;

    public Op(){}

    public Op(Double va, Double vb) {
        this.va = va;
        this.vb = vb;
    }

    public Double getVa() {
        return va;
    }
    public void setVa(Double va) {
        this.va = va;
    }

    public Double getVb() {
        return vb;
    }
    public void setVb(Double vb) {
        this.vb = vb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Op op = (Op) o;
        return Objects.equals(getVa(), op.getVa()) &&
                Objects.equals(getVb(), op.getVb());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVa(), getVb());
    }

    @Override
    public String toString() {
        return "Op{" +
                "va=" + va +
                ", vb=" + vb +
                '}';
    }
}
