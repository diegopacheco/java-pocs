package com.github.diegopacheco.functional.interfaces.functionalinterface;

public class FunctionalInterfaceApp {
    public static void main(String[] args) {
        innerClassStyle();
        lambdaStyle();
        methodReference();
    }

    public static void innerClassStyle(){
        DoubleToInt dbl = new DoubleToInt() {
            @Override
            public Integer convert(Double input) {
                return input.intValue();
            }
        };
        System.out.println(dbl.convert(42.0));
    }

    public static void lambdaStyle(){
        DoubleToInt dbl = (Double v) -> v.intValue();
        System.out.println(dbl.convert(42.0));
    }

    public static void methodReference(){
        DoubleToInt dbl = Double::intValue;
        System.out.println(dbl.convert(42.0));
    }

}
