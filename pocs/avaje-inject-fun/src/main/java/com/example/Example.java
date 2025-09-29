package com.example;

import jakarta.inject.Singleton;

@Singleton
public class Example {

    private DependencyClass d1;
    private DependencyClass2 d2;

    // Dependencies must be annotated with singleton,
    // or else be provided from another class annotated with @Factory
    public Example(DependencyClass d1, DependencyClass2 d2) {
        this.d1 = d1;
        this.d2 = d2;
    }
}