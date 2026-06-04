package com.github.diegopacheco.proxy;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;

public final class ProxyHandler implements HttpHandler {

    private static final Set<String> SKIP_REQUEST = Set.of(
            "host", "content-length", "connection", "upgrade", "transfer-encoding",
            "keep-alive", "proxy-connection", "te", "trailer", "expect");
    private static final Set<String> SKIP_RESPONSE = Set.of(
            "content-length", "transfer-encoding", "connection");

    private final URI backend;
    private final HttpClient client;
    private final TrafficLog log;
    private final Stats stats;
    private final int maxBody;

    public ProxyHandler(URI backend, HttpClient client, TrafficLog log, Stats stats, int maxBody) {
        this.backend = backend;
        this.client = client;
        this.log = log;
        this.stats = stats;
        this.maxBody = maxBody;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        long start = System.nanoTime();
        String method = exchange.getRequestMethod();
        String rawPath = exchange.getRequestURI().getRawPath();
        String rawQuery = exchange.getRequestURI().getRawQuery();
        String pathAndQuery = rawQuery == null ? rawPath : rawPath + "?" + rawQuery;
        byte[] reqBody = exchange.getRequestBody().readAllBytes();

        HttpRequest.Builder builder = HttpRequest.newBuilder(URI.create(backend.toString() + pathAndQuery))
                .timeout(Duration.ofSeconds(15));
        builder.method(method, reqBody.length > 0
                ? HttpRequest.BodyPublishers.ofByteArray(reqBody)
                : HttpRequest.BodyPublishers.noBody());
        exchange.getRequestHeaders().forEach((key, values) -> {
            if (key == null || SKIP_REQUEST.contains(key.toLowerCase())) {
                return;
            }
            for (String value : values) {
                try {
                    builder.header(key, value);
                } catch (IllegalArgumentException ignored) {
                }
            }
        });

        int status;
        byte[] respBody;
        boolean backendResponded = false;
        try {
            HttpResponse<byte[]> response = client.send(builder.build(), HttpResponse.BodyHandlers.ofByteArray());
            status = response.statusCode();
            respBody = response.body();
            backendResponded = true;
            response.headers().map().forEach((key, values) -> {
                if (SKIP_RESPONSE.contains(key.toLowerCase())) {
                    return;
                }
                exchange.getResponseHeaders().put(key, values);
            });
        } catch (Exception e) {
            status = 502;
            respBody = ("{\"error\":\"backend unreachable\",\"detail\":" + Json.str(String.valueOf(e.getMessage())) + "}")
                    .getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "application/json");
        }

        long durationMs = (System.nanoTime() - start) / 1_000_000;
        long length = respBody.length == 0 ? -1 : respBody.length;
        exchange.sendResponseHeaders(status, length);
        if (respBody.length > 0) {
            exchange.getResponseBody().write(respBody);
        }
        exchange.close();

        stats.proxy(method, status);
        if (backendResponded) {
            stats.backend(method, status);
        }
        log.append(new LogEntry(
                Instant.now().toString(),
                method,
                pathAndQuery,
                status,
                durationMs,
                truncate(new String(reqBody, StandardCharsets.UTF_8)),
                truncate(new String(respBody, StandardCharsets.UTF_8))));
    }

    private String truncate(String value) {
        return value.length() > maxBody ? value.substring(0, maxBody) : value;
    }
}
