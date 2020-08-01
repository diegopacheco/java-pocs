package com.github.diegopacheco.javapocs.effectivejava3.immutable;

public class Main {
    public static void main(String[] args) {
        Complex c1 = new Complex(1,0.5);
        Complex c2 = new Complex(2,0.5);
        System.out.println("complex 1 " + c1);
        System.out.println("complex 2 " + c2);
        System.out.println("complex 3 " + (c1.plus(c2)) );
    }
}
