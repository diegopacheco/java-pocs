package com.github.diegopacheco.java27.structuredconcurrency;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Joiner;

public final class StructuredConcurrency {

    public record Order(String user, String item) {}

    public static Order load(String user, String item) throws ExecutionException, InterruptedException {
        try (var scope = StructuredTaskScope.open(Joiner.<String>allSuccessfulOrThrow())) {
            scope.fork(() -> lookup("user", user));
            scope.fork(() -> lookup("item", item));
            List<String> parts = scope.join();
            return new Order(parts.get(0), parts.get(1));
        }
    }

    public static Order loadOrFail(String user, String item) throws OrderFailedException, InterruptedException {
        try (var scope = StructuredTaskScope.open(Joiner.<String, OrderFailedException>allSuccessfulOrThrow(OrderFailedException::new))) {
            scope.fork(() -> lookup("user", user));
            scope.fork(() -> lookup("item", item));
            List<String> parts = scope.join();
            return new Order(parts.get(0), parts.get(1));
        }
    }

    public static String fastest(Duration budget, String... candidates) throws ExecutionException, InterruptedException {
        try (var scope = StructuredTaskScope.open(Joiner.<String>anySuccessfulOrThrow(),
                config -> config.withTimeout(budget))) {
            for (int i = 0; i < candidates.length; i++) {
                String candidate = candidates[i];
                long delay = (i + 1) * 20L;
                scope.fork(() -> {
                    Thread.sleep(delay);
                    return candidate;
                });
            }
            return scope.join();
        }
    }

    private static String lookup(String kind, String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("missing " + kind);
        }
        return kind + ":" + value;
    }
}
