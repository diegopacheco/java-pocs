package com.github.diegopacheco.pocs.seda.metrics;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Since is a POC I'm doing basic error observability, but we could do more like:
 *   + Capture Exception types and counters
 *   + Latency % p50, p75, p90, p95, p99
 *   + Arrival rate per queue
 *   + Departure rate per queue
 *   + avg, mean processing times
 *   + much more...
 */
public class MetricsManager {

    private static Map<String, AtomicInteger> operationCounters = new ConcurrentHashMap<>();
    private static Map<String, AtomicInteger> errorCounters = new ConcurrentHashMap<>();

    public static void ok(String stage){
        String key = stage + "-ok";
        AtomicInteger count = operationCounters.getOrDefault(key, new AtomicInteger(0));
        count.incrementAndGet();
        operationCounters.put(key,count);
    }

    public static void error(String stage){
        String key = stage + "-error";
        AtomicInteger count = errorCounters.getOrDefault(key, new AtomicInteger(0));
        count.incrementAndGet();
        errorCounters.put(key,count);
    }

    public static Map<String,String> statistics(){
        Map<String,String> deepCopyOk = operationCounters.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().toString()));

        Map<String,String> deepCopyError = errorCounters.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().toString()));

        Map<String,String> result = new HashMap<>();
        result.putAll(deepCopyOk);
        result.putAll(deepCopyError);
        return result;
    }

}
