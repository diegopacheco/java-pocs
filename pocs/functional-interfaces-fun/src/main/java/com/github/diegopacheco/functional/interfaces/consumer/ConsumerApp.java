package com.github.diegopacheco.functional.interfaces.consumer;

import java.util.function.Consumer;

public class ConsumerApp {
    public static void main(String[] args) {
        Consumer<String> logger = System.out::println;
        logger.accept("Hello World");
    }
}
