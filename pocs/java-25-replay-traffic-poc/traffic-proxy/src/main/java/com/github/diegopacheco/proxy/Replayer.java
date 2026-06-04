package com.github.diegopacheco.proxy;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Replayer {

    private static final int MAX_FAILURES = 100;

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
        List<Map<String, Object>> failures = new ArrayList<>();
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
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                int status = response.statusCode();
                bump(byStatus, String.valueOf(status));
                if (status >= 200 && status < 400) {
                    succeeded++;
                } else {
                    failed++;
                    if (failures.size() < MAX_FAILURES) {
                        failures.add(failure(entry.path(), status, snippet(response.body())));
                    }
                }
            } catch (Exception e) {
                failed++;
                bump(byStatus, "error");
                if (failures.size() < MAX_FAILURES) {
                    failures.add(failure(entry.path(), "error", String.valueOf(e.getMessage())));
                }
            }
        }
        Map<String, Object> out = new LinkedHashMap<>();
        out.put("totalInLog", entries.size());
        out.put("skippedWrites", skippedWrites);
        out.put("replayed", replayed);
        out.put("succeeded", succeeded);
        out.put("failed", failed);
        out.put("byStatus", byStatus);
        out.put("failures", failures);
        return out;
    }

    private static Map<String, Object> failure(String path, Object status, String detail) {
        Map<String, Object> entry = new LinkedHashMap<>();
        entry.put("path", path);
        entry.put("status", status);
        entry.put("detail", detail);
        return entry;
    }

    private static String snippet(String body) {
        if (body == null || body.isBlank()) {
            return "(no response body)";
        }
        String trimmed = body.strip();
        return trimmed.length() > 200 ? trimmed.substring(0, 200) : trimmed;
    }

    private static void bump(Map<String, Object> map, String key) {
        map.merge(key, 1L, (a, b) -> ((Number) a).longValue() + ((Number) b).longValue());
    }
}
