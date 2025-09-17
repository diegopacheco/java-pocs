package com.github.diegopacheco.java25.features;

import java.util.function.Supplier;

/*
 * JEP 502: Stable Values (Preview)
 * https://openjdk.org/jeps/502
 *
 * Stable values are a new kind of variable that, once initialized, cannot be changed.
 * They are designed to improve performance and safety in concurrent programming by ensuring that
 * certain values remain constant after their initial assignment.
 */
public class StableValuess {

    private static final StableValue<String> message = StableValue.of();
    private static final Supplier<Integer> counter = StableValue.supplier(() -> 42);

    static void main() {
        System.out.println("First access: " + message.orElseSet(() -> "Hello Java 25"));
        System.out.println("Second access: " + message.orElseSet(() -> "This won't be called"));

        System.out.println("Counter first: " + counter.get());
        System.out.println("Counter second: " + counter.get());

        var numbers = StableValue.list(3, i -> i * 10);
        System.out.println("List[0]: " + numbers.get(0));
        System.out.println("List[2]: " + numbers.get(2));
        System.out.println("List[0] again: " + numbers.get(0));
    }
}
