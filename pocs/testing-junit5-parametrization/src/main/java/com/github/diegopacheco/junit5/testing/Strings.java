package com.github.diegopacheco.junit5.testing;

public class Strings {
    public static boolean isBlank(String input) {
        return null == input  || input.trim().isEmpty();
    }
}
