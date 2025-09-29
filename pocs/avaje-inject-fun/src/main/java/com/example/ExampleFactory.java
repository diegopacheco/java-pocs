package com.example;

import io.avaje.inject.Bean;
import io.avaje.inject.Factory;

@Factory
public class ExampleFactory {
    @Bean
    public DependencyClass2 bean() {
        return new DependencyClass2();
    }
}