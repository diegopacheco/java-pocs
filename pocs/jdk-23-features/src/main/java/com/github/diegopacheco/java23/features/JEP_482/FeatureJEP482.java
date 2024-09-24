package com.github.diegopacheco.java23.features.JEP_482;

import java.math.BigInteger;

/**
 * JEP 482: Flexible Constructor Bodies (Second Preview)
 * https://openjdk.org/jeps/482
 */
public class FeatureJEP482 {

    public class PositiveBigInteger extends BigInteger {
        public PositiveBigInteger(long value) {
            if (value <= 0) throw new IllegalArgumentException("Value must be positive");
            super(String.valueOf(value));
        }

    }

    public static void main(String[] args) {
        FeatureJEP482 app = new FeatureJEP482();
        PositiveBigInteger positiveBigInteger = app.new PositiveBigInteger(10);
        System.out.println(positiveBigInteger);
    }
}
