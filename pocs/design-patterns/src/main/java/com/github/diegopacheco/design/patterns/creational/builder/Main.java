package com.github.diegopacheco.design.patterns.creational.builder;

public class Main {
    public static void main(String[] args) {
        ConfigBuilder conf = ConfigBuilder.Builder.standard()
                .withHost("127.0.0.1")
                .withPath("/healthchecker")
                .withPort(8080)
                .build();
        System.out.println(conf);
    }
}
