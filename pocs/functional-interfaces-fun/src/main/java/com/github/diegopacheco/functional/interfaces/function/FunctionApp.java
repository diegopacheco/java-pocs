package com.github.diegopacheco.functional.interfaces.function;

import java.util.function.Function;

public class FunctionApp {
    public static void main(String[] args) {
        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";
        Function<Integer, String> quoteIntToString = quote.compose(intToString);
        System.out.println(quoteIntToString.apply(5));
    }
}
