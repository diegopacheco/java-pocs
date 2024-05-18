package com.github.diegopacheco.jeps;

import java.math.BigInteger;

public class StatementBeforeSuper {

    public static class PositiveBigInteger extends BigInteger {
        public PositiveBigInteger(long value) {
            super(verifyPositive(value));
        }
        private static String verifyPositive(long value) {
            if (value <= 0)
                throw new IllegalArgumentException("non-positive value");
            return value+"";
        }
    }

    public static void run(){
        System.out.println("447: Statements before super(...) (Preview)");

        BigInteger bi = new PositiveBigInteger(10);
        System.out.println(bi);
    }

}
