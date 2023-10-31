package com.github.diegopacheco.functional.interfaces.functionalinterface;

public class FunctionalInterfaceApp {
    public static void main(String[] args) {
        DoubleToInt dbl = Double::intValue;
        System.out.println(dbl.convert(42.0));
    }
}
