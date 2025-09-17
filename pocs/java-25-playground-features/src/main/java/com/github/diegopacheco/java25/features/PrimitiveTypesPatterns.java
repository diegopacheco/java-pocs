package com.github.diegopacheco.java25.features;

/*
 * JEP 507: Primitive Types in Patterns, instanceof, and switch (Third Preview)
 * https://openjdk.org/jeps/507
 *
 * This feature allows the use of primitive types in pattern matching with instanceof and switch statements.
 * This enhances the expressiveness of the language by enabling more concise and readable
 * code when working with primitive types.
 */
public class PrimitiveTypesPatterns {
    static void main() {
        int value = 42;

        if (value instanceof byte b) {
            System.out.println("Fits in byte: " + b);
        }

        switch (value) {
            case 0 -> System.out.println("Zero");
            case 42 -> System.out.println("Answer");
            case int i when i > 100 -> System.out.println("Large: " + i);
            case int i -> System.out.println("Other: " + i);
        }

        boolean flag = true;
        switch (flag) {
            case true -> System.out.println("True case");
            case false -> System.out.println("False case");
        }
    }
}
