package com.github.diegopacheco.proxy;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Replayer {

    private final URI backend;
    private final HttpClient client;
    private final TrafficLog log;

    public Replayer(URI backend, HttpClient client, TrafficLog log) {
        this.backend = backend;
        this.client = client;
        this.log = log;
    }

    public Map<String, Object> replay() {
        List<LogEntry> entries = log.read();
        Map<String, Object> byStatus = new LinkedHashMap<>();
        int skippedWrites = 0;
        int replayed = 0;
        int succeeded = 0;
        int failed = 0;
        for (LogEntry entry : entries) {
            if (!"GET".equalsIgnoreCase(entry.method())) {
                skippedWrites++;
                continue;
            }
            replayed++;
            try {
                HttpRequest request = HttpRequest.newBuilder(URI.create(backend.toString() + entry.path()))
                        .timeout(Duration.ofSeconds(10))
                        .GET()
                        .build();
                int status = client.send(request, HttpResponse.BodyHandlers.ofString()).statusCode();
                bump(byStatus, String.valueOf(status));
                if (status >= 200 && status < 400) {
                    succeeded++;
                } else {
                    failed++;
                }
            } catch (Exception e) {
                bump(byStatus, "error");
                failed++;
            }
        }
        Map<String, Object> out = new LinkedHashMap<>();
        out.put("totalInLog", entries.size());
        out.put("skippedWrites", skippedWrites);
        out.put("replayed", replayed);
        out.put("succeeded", succeeded);
        out.put("failed", failed);
        out.put("byStatus", byStatus);
        return out;
    }

    private static void bump(Map<String, Object> map, String key) {
        map.merge(key, 1L, (a, b) -> ((Number) a).longValue() + ((Number) b).longValue());
    }
}
