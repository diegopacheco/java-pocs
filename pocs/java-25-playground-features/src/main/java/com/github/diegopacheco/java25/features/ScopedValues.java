package com.github.diegopacheco.java25.features;

 import static java.lang.ScopedValue.where;

/*
 * JEP 506: Scoped Values
 * https://openjdk.org/jeps/506
 *
 * Scoped values provide a way to share immutable data within and across threads in a structured manner.
 * They are designed to be a safer and more efficient alternative to thread-local variables.
 * Scoped values are defined using the `ScopedValue` class, which allows you to create a
 * scoped value and set its value within a specific scope.
 */
public class ScopedValues {

    private static final ScopedValue<String> USER = ScopedValue.newInstance();
    private static final ScopedValue<Integer> SESSION = ScopedValue.newInstance();

    static void main() {
        where(USER, "Alice")
            .where(SESSION, 12345)
            .run(() -> {
                processRequest();
                nestedCall();
            });
    }

    static void processRequest() {
        System.out.println("User: " + USER.get() + " Session: " + SESSION.get());
    }

    static void nestedCall() {
        where(USER, "Bob").run(() -> System.out.println("Nested: " + USER.get()));
        System.out.println("Back to: " + USER.get());
    }
}
