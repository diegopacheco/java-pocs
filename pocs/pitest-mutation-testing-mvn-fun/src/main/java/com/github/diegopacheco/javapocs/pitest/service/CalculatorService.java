package com.github.diegopacheco.javapocs.pitest.service;

import java.util.Objects;

public class CalculatorService {

    public double sum(double arg1,double arg2){
        validate(arg1,arg2);
        return arg1 + arg2;
    }

    public double mul(double arg1, double arg2){
        validate(arg1,arg2);
        return arg1 * arg2;
    }

    public double divide(double arg1,double arg2){
        validate(arg1,arg2);
        if (0==arg1 || 0==arg2)
            throw new IllegalArgumentException("Args cannot be ZERO.");
        return arg1 / arg2;
    }

    public double sub(double arg1, double arg2){
        validate(arg1,arg2);
        return arg1 - arg2;
    }

    private void validate(double one,double two){
        Objects.requireNonNull(one);
        Objects.requireNonNull(two);
    }

}
