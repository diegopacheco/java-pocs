package com.github.diegopacheco.java25.features;

import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

/*
 * JEP 505: Structured Concurrency (Fifth Preview)
 * https://openjdk.org/jeps/505
 *
 * Simplify concurrent programming by introducing an API for structured concurrency.
 * Structured concurrency treats groups of related tasks running in different threads
 * as single units of work, thereby streamlining error handling and cancellation,
 * improving reliability, and enhancing observability.
 */
public class StructuredConcurrency {

    static void main() throws InterruptedException {
        try (var scope = StructuredTaskScope.open()) {
            Subtask<String> task1 = scope.fork(() -> "Hello " + Thread.currentThread().getName());
            Subtask<String> task2 = scope.fork(() -> "from " + Thread.currentThread().getName());
            Subtask<Integer> task3 = scope.fork(() -> 42);

            scope.join();

            System.out.println(task1.get());
            System.out.println(task2.get());
            System.out.println(task3.get());
        }
    }
}
