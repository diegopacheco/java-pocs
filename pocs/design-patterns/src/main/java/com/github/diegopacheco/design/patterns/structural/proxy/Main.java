package com.github.diegopacheco.design.patterns.structural.proxy;

public class Main {
    public static void main(String[] args) {
        IDGenerator generator = new IDGeneratorFactory().create();
        System.out.println(generator.getNext());
        System.out.println(generator.getNext());
    }
}
