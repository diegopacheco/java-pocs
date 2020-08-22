package com.github.diegopacheco.javapocs.powermock.deep;

import java.util.Objects;

public class Result {

    private int a;
    private int b;
    private int sum;

    public Result(){}

    public Result(int a, int b, int sum) {
        this.a = a;
        this.b = b;
        this.sum = sum;
    }

    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }

    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return getA() == result.getA() &&
                getB() == result.getB() &&
                getSum() == result.getSum();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getA(), getB(), getSum());
    }

    @Override
    public String toString() {
        return "Result{" +
                "a=" + a +
                ", b=" + b +
                ", sum=" + sum +
                '}';
    }
}
