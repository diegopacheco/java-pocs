package com.github.diegopacheco.proxy;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public final class TrafficGenerator {

    private static final int ID_RANGE = 50;

    private final URI proxy;
    private final HttpClient client;

    public TrafficGenerator(URI proxy, HttpClient client) {
        this.proxy = proxy;
        this.client = client;
    }

    public Map<String, Object> generate(String method, int count) {
        Map<String, Object> byStatus = new LinkedHashMap<>();
        int ok = 0;
        int failed = 0;
        for (int n = 0; n < count; n++) {
            try {
                int status = fire(method).statusCode();
                bump(byStatus, String.valueOf(status));
                if (status >= 200 && status < 400) {
                    ok++;
                } else {
                    failed++;
                }
            } catch (Exception e) {
                bump(byStatus, "error");
                failed++;
            }
        }
        Map<String, Object> out = new LinkedHashMap<>();
        out.put("method", method.toUpperCase());
        out.put("requested", count);
        out.put("ok", ok);
        out.put("failed", failed);
        out.put("byStatus", byStatus);
        return out;
    }

    private HttpResponse<String> fire(String method) throws Exception {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int id = random.nextInt(1, ID_RANGE + 1);
        return switch (method.toUpperCase()) {
            case "GET" -> send("GET", random.nextBoolean() ? "/books" : "/books/" + id, null);
            case "PUT" -> {
                Map<String, Object> body = new LinkedHashMap<>();
                body.put("title", "Book #" + id);
                body.put("author", "Author " + random.nextInt(1, 200));
                body.put("price", Math.round(random.nextDouble(5, 80) * 100.0) / 100.0);
                body.put("stock", random.nextInt(0, 100));
                yield send("PUT", "/books/" + id, Json.write(body));
            }
            case "DELETE" -> send("DELETE", "/books/" + id, null);
            default -> send(method.toUpperCase(), "/books", null);
        };
    }

    private HttpResponse<String> send(String method, String path, String body) throws Exception {
        HttpRequest.Builder builder = HttpRequest.newBuilder(URI.create(proxy.toString() + path))
                .timeout(Duration.ofSeconds(10));
        if (body != null) {
            builder.header("Content-Type", "application/json");
            builder.method(method, HttpRequest.BodyPublishers.ofString(body));
        } else {
            builder.method(method, HttpRequest.BodyPublishers.noBody());
        }
        return client.send(builder.build(), HttpResponse.BodyHandlers.ofString());
    }

    private static void bump(Map<String, Object> map, String key) {
        map.merge(key, 1L, (a, b) -> ((Number) a).longValue() + ((Number) b).longValue());
    }
}
