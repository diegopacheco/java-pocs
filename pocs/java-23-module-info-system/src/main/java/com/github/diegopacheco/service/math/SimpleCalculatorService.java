package com.github.diegopacheco.service.math;

public class SimpleCalculatorService implements Calculator {

    public SimpleCalculatorService(){}

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double sub(double a, double b) {
        return a - b;
    }

    @Override
    public double mul(double a, double b) {
        return a * b;
    }

    @Override
    public double div(double a, double b) {
        return a / b;
    }

    @Override
    public double pow(double a, double b) {
        return Math.pow(a, b);
    }

    @Override
    public double sqrt(double a) {
        return Math.sqrt(a);
    }

    @Override
    public double sin(double a) {
        return Math.sin(a);
    }

    @Override
    public double cos(double a) {
        return Math.cos(a);
    }

    @Override
    public double tan(double a) {
        return Math.tan(a);
    }
}
