package com.github.diegopacheco.functional.interfaces.supplier;

import java.util.function.Supplier;

public class SupplierApp {
    public static void main(String[] args) {
        Supplier<Integer> lazyFunction = () -> 8080;
        System.out.println("Server por is : " + lazyFunction.get());
    }
}
