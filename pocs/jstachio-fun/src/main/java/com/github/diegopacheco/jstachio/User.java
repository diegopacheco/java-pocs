package com.github.diegopacheco.jstachio;

import io.jstach.jstache.JStache;

import java.util.List;

@JStache(
        path = "user.mustache",
        template = ""
)
public record User(String name, int age, String[] array, List<Item<String>> list) {
    public static class Item<T> {
        private final T value;
        public Item(T value) {
            this.value = value;
        }
        T value() {
            return value;
        }
    }
}