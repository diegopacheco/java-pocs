package com.github.diegopacheco.javapocs.pitest.test.service;

import java.util.Objects;

public class CalculatorService<T extends Number> {

    public double sum(T arg1, T arg2){
        validate(arg1,arg2);
        return arg1.doubleValue() + arg2.doubleValue();
    }

    public double mul(T arg1, T arg2){
        validate(arg1,arg2);
        return arg1.doubleValue() * arg2.doubleValue();
    }

    public double divide(T arg1, T arg2){
        validate(arg1,arg2);
        return arg1.doubleValue() / arg2.doubleValue();
    }

    public double sub(T arg1, T arg2){
        validate(arg1,arg2);
        return arg1.doubleValue() - arg2.doubleValue();
    }

    private void validate(T one,T two){
        Objects.requireNonNull(one);
        Objects.requireNonNull(two);
    }

}
