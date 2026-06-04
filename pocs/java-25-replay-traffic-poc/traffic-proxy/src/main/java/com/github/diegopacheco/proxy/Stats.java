package com.github.diegopacheco.proxy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public final class Stats {

    private final Map<String, LongAdder> proxyByMethod = new ConcurrentHashMap<>();
    private final Map<String, LongAdder> proxyByStatus = new ConcurrentHashMap<>();
    private final Map<String, LongAdder> backendByMethod = new ConcurrentHashMap<>();
    private final Map<String, LongAdder> backendByStatus = new ConcurrentHashMap<>();
    private final LongAdder proxyTotal = new LongAdder();
    private final LongAdder backendTotal = new LongAdder();

    public void proxy(String method, int status) {
        proxyTotal.increment();
        proxyByMethod.computeIfAbsent(method, k -> new LongAdder()).increment();
        proxyByStatus.computeIfAbsent(String.valueOf(status), k -> new LongAdder()).increment();
    }

    public void backend(String method, int status) {
        backendTotal.increment();
        backendByMethod.computeIfAbsent(method, k -> new LongAdder()).increment();
        backendByStatus.computeIfAbsent(String.valueOf(status), k -> new LongAdder()).increment();
    }

    public Map<String, Object> snapshot() {
        Map<String, Object> proxy = new LinkedHashMap<>();
        proxy.put("total", proxyTotal.sum());
        proxy.put("byMethod", toMap(proxyByMethod));
        proxy.put("byStatus", toMap(proxyByStatus));

        Map<String, Object> backend = new LinkedHashMap<>();
        backend.put("total", backendTotal.sum());
        backend.put("byMethod", toMap(backendByMethod));
        backend.put("byStatus", toMap(backendByStatus));

        Map<String, Object> root = new LinkedHashMap<>();
        root.put("proxy", proxy);
        root.put("backend", backend);
        return root;
    }

    private static Map<String, Object> toMap(Map<String, LongAdder> source) {
        Map<String, Object> out = new LinkedHashMap<>();
        source.forEach((k, v) -> out.put(k, v.sum()));
        return out;
    }
}
