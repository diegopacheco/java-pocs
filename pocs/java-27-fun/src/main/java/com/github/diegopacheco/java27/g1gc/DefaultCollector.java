package com.github.diegopacheco.java27.g1gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public final class DefaultCollector {

    public static List<String> names() {
        return ManagementFactory.getGarbageCollectorMXBeans().stream()
                .map(GarbageCollectorMXBean::getName)
                .toList();
    }

    public static boolean isG1() {
        return names().stream().anyMatch(name -> name.startsWith("G1"));
    }

    public static long collections() {
        return ManagementFactory.getGarbageCollectorMXBeans().stream()
                .mapToLong(GarbageCollectorMXBean::getCollectionCount)
                .filter(count -> count >= 0)
                .sum();
    }
}
