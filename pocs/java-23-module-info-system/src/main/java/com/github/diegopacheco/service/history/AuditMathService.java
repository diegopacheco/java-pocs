package com.github.diegopacheco.service.history;

import com.github.diegopacheco.service.math.Calculator;

import java.util.Collections;
import java.util.Map;

public class AuditMathService implements Calculator {

    private final Calculator calculator;
    private final Map<String,String> history;

    public AuditMathService(Calculator calculator) {
        this.calculator = calculator;
        this.history = new java.util.HashMap<>();
    }

    public Map<String, String> getHistory() {
        return Collections.unmodifiableMap(history);
    }

    @Override
    public double add(double a, double b) {
        String key = a + "+" + b;
        String value = calculator.add(a, b) + "";
        history.put(key, value);
        return calculator.add(a, b);
    }

    @Override
    public double sub(double a, double b) {
        String key = a + "-" + b;
        String value = calculator.sub(a, b) + "";
        history.put(key, value);
        return calculator.sub(a, b);
    }

    @Override
    public double mul(double a, double b) {
        String key = a + "*" + b;
        String value = calculator.mul(a, b) + "";
        history.put(key, value);
        return calculator.mul(a, b);
    }

    @Override
    public double div(double a, double b) {
        String key = a + "/" + b;
        String value = calculator.div(a, b) + "";
        history.put(key, value);
        return calculator.div(a, b);
    }

    @Override
    public double pow(double a, double b) {
        String key = a + "^" + b;
        String value = calculator.pow(a, b) + "";
        history.put(key, value);
        return calculator.pow(a, b);
    }

    @Override
    public double sqrt(double a) {
        String key = "sqrt(" + a + ")";
        String value = calculator.sqrt(a) + "";
        history.put(key, value);
        return calculator.sqrt(a);
    }

    @Override
    public double sin(double a) {
        String key = "sin(" + a + ")";
        String value = calculator.sin(a) + "";
        history.put(key, value);
        return calculator.sin(a);
    }

    @Override
    public double cos(double a) {
        String key = "cos(" + a + ")";
        String value = calculator.cos(a) + "";
        history.put(key, value);
        return calculator.cos(a);
    }

    @Override
    public double tan(double a) {
        String key = "tan(" + a + ")";
        String value = calculator.tan(a) + "";
        history.put(key, value);
        return calculator.tan(a);
    }

}
