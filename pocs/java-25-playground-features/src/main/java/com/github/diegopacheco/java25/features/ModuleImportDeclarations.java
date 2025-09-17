package com.github.diegopacheco.java25.features;

import module java.base;
import module java.desktop;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.nio.file.Path;

/*
 * JEP 511: Module Import Declarations
 * https://openjdk.org/jeps/511
 *
 * This feature allows explicit import of modules in Java source files.
 * It enhances code readability and maintainability by making module dependencies clear.
 *
 */
public class ModuleImportDeclarations {
    static void main() {
        List<String> fruits = List.of("apple", "banana", "cherry");
        Map<String, Integer> fruitCounts = fruits.stream()
            .collect(Collectors.toMap(
                Function.identity(),
                String::length
            ));

        System.out.println("Fruits: " + fruits);
        System.out.println("Counts: " + fruitCounts);

        Path file = Path.of("test.txt");
        System.out.println("Path: " + file.toAbsolutePath());
    }
}
