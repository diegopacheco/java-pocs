package com.github.diegopacheco.sandboxspring.metrics;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class OperationMonitor {

    private static Map<String, AtomicInteger> okCounters = new ConcurrentHashMap<>();
    private static Map<String, AtomicInteger> errorCounters = new ConcurrentHashMap<>();
    private static Map<String, AtomicLong> latestLatencies = new ConcurrentHashMap<>();
    private static Map<String, AtomicInteger> avgLatencies = new ConcurrentHashMap<>();
    private static Map<String, Exception> lastExceptions = new ConcurrentHashMap<>();

    public static void recordException(String operation,Exception ex){
        lastExceptions.put("exception-" + operation,ex);
    }

    public static void recordLatency(String operation,long timeInMS){
        operation = "latency"+operation;
        AtomicLong counter = latestLatencies.get(operation);
        if (null==counter){
            counter = new AtomicLong(timeInMS);
            latestLatencies.put(operation,counter);
        }
        if (Integer.MAX_VALUE<timeInMS){
            counter = new AtomicLong(0);
            latestLatencies.put(operation,counter);
        }
    }

    public static void recordSuccess(String operation){
        record("sucess-" + operation,okCounters);
    }

    public static void recordError(String operation){
        record("error-" + operation,errorCounters);
    }

    private static void record(String operation,Map<String, AtomicInteger> map){
        AtomicInteger counter = map.get(operation);
        if (null==counter){
            counter = new AtomicInteger(0);
            map.put(operation,counter);
        }
        if (Integer.MAX_VALUE<counter.get()){
            counter = new AtomicInteger(0);
            map.put(operation,counter);
        }
        counter.incrementAndGet();
    }

    public static Map<String,Object> dump(){
        Map<String, Object> allMetrics = new ConcurrentHashMap<>();
        allMetrics.putAll(okCounters);
        allMetrics.putAll(errorCounters);
        allMetrics.putAll(latestLatencies);
        allMetrics.putAll(avgLatencies);
        allMetrics.putAll(lastExceptions);
        return allMetrics;
    }

}
