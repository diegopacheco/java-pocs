package com.github.diegopacheco.java27.lazyconstants;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class LazyConstants {

    public enum Option { VERBOSE, DRY_RUN, STRICT }

    private final AtomicInteger initializations = new AtomicInteger();

    private final LazyConstant<String> banner = LazyConstant.of(() -> {
        initializations.incrementAndGet();
        return "Java 27 lazy constant";
    });

    private final List<Integer> squares = List.ofLazy(5, index -> {
        initializations.incrementAndGet();
        return index * index;
    });

    private final Map<String, Integer> widths = Map.ofLazy(Set.of("jep", "lazy", "constant"), key -> {
        initializations.incrementAndGet();
        return key.length();
    });

    private final Set<Option> enabled = Set.ofLazy(EnumSet.allOf(Option.class), option -> {
        initializations.incrementAndGet();
        return option != Option.DRY_RUN;
    });

    public String banner() {
        return banner.get();
    }

    public int square(int index) {
        return squares.get(index);
    }

    public int width(String key) {
        return widths.get(key);
    }

    public boolean isEnabled(Option option) {
        return enabled.contains(option);
    }

    public int initializations() {
        return initializations.get();
    }
}
