package com.github.diegopacheco.pocs.seda.ff;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class FeatureFlagManager {

    private static Map<String, Object> flags = new ConcurrentHashMap<>();

    public static final String QUEUE_SANITIZER_TIME_BACKPRESSURE_MS = "$QUEUE_SANITIZER_TIME_BACKPRESSURE_MS";
    public static final String QUEUE_CAT_TIME_BACKPRESSURE_MS = "$QUEUE_CAT_TIME_BACKPRESSURE_MS";
    public static final String QUEUE_CONSOLE_TIME_BACKPRESSURE_MS = "$QUEUE_CONSOLE_TIME_BACKPRESSURE_MS";

    public static <T> void set(String flag, T value) {
        flags.put(flag, value);
    }

    public static <T> T get(String flag) {
        return (T) flags.get(flag);
    }

    public static Map<String, String> flags() {
        Map<String, String> deepCopy = flags.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().toString()));
        return deepCopy;
    }

}
