package com.github.diegopacheco.proxy;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ControlApi {

    private final TrafficLog log;
    private final Stats stats;
    private final TrafficGenerator generator;
    private final Replayer replayer;
    private final URI backend;

    public ControlApi(TrafficLog log, Stats stats, TrafficGenerator generator, Replayer replayer, URI backend) {
        this.log = log;
        this.stats = stats;
        this.generator = generator;
        this.replayer = replayer;
        this.backend = backend;
    }

    public void register(HttpServer server) {
        server.createContext("/api/health", this::health);
        server.createContext("/api/stats", this::statsHandler);
        server.createContext("/api/log", this::logHandler);
        server.createContext("/api/generate", this::generateHandler);
        server.createContext("/api/replay", this::replayHandler);
    }

    private void health(HttpExchange exchange) throws IOException {
        if (preflight(exchange)) {
            return;
        }
        Map<String, Object> out = new LinkedHashMap<>();
        out.put("status", "up");
        out.put("backend", backend.toString());
        out.put("logPath", log.path().toAbsolutePath().toString());
        json(exchange, 200, Json.write(out));
    }

    private void statsHandler(HttpExchange exchange) throws IOException {
        if (preflight(exchange)) {
            return;
        }
        Map<String, Object> out = stats.snapshot();
        out.put("logEntries", log.count());
        out.put("logPath", log.path().toAbsolutePath().toString());
        json(exchange, 200, Json.write(out));
    }

    private void logHandler(HttpExchange exchange) throws IOException {
        if (preflight(exchange)) {
            return;
        }
        String method = queryParam(exchange.getRequestURI().getQuery(), "method");
        List<Map<String, Object>> entries = new ArrayList<>();
        for (LogEntry entry : log.read()) {
            if (method != null && !method.isBlank() && !method.equalsIgnoreCase(entry.method())) {
                continue;
            }
            entries.add(entry.toMap());
        }
        Map<String, Object> out = new LinkedHashMap<>();
        out.put("count", entries.size());
        out.put("entries", entries);
        json(exchange, 200, Json.write(out));
    }

    private void generateHandler(HttpExchange exchange) throws IOException {
        if (preflight(exchange)) {
            return;
        }
        if (!"POST".equalsIgnoreCase(exchange.getRequestMethod())) {
            json(exchange, 405, "{\"error\":\"use POST\"}");
            return;
        }
        Map<String, Object> body = readJson(exchange);
        String method = String.valueOf(body.getOrDefault("method", "GET"));
        int count = ((Number) body.getOrDefault("count", 10L)).intValue();
        if (count < 1) {
            count = 1;
        }
        if (count > 500) {
            count = 500;
        }
        json(exchange, 200, Json.write(generator.generate(method, count)));
    }

    private void replayHandler(HttpExchange exchange) throws IOException {
        if (preflight(exchange)) {
            return;
        }
        if (!"POST".equalsIgnoreCase(exchange.getRequestMethod())) {
            json(exchange, 405, "{\"error\":\"use POST\"}");
            return;
        }
        json(exchange, 200, Json.write(replayer.replay()));
    }

    private Map<String, Object> readJson(HttpExchange exchange) throws IOException {
        byte[] bytes = exchange.getRequestBody().readAllBytes();
        if (bytes.length == 0) {
            return new LinkedHashMap<>();
        }
        Object parsed = Json.parse(new String(bytes, StandardCharsets.UTF_8));
        if (parsed instanceof Map<?, ?> map) {
            Map<String, Object> out = new LinkedHashMap<>();
            map.forEach((k, v) -> out.put(String.valueOf(k), v));
            return out;
        }
        return new LinkedHashMap<>();
    }

    private static String queryParam(String query, String name) {
        if (query == null) {
            return null;
        }
        for (String pair : query.split("&")) {
            int eq = pair.indexOf('=');
            if (eq > 0 && pair.substring(0, eq).equals(name)) {
                return pair.substring(eq + 1);
            }
        }
        return null;
    }

    private static void cors(HttpExchange exchange) {
        Headers headers = exchange.getResponseHeaders();
        headers.set("Access-Control-Allow-Origin", "*");
        headers.set("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        headers.set("Access-Control-Allow-Headers", "Content-Type");
    }

    private static boolean preflight(HttpExchange exchange) throws IOException {
        if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
            cors(exchange);
            exchange.sendResponseHeaders(204, -1);
            exchange.close();
            return true;
        }
        return false;
    }

    private static void json(HttpExchange exchange, int status, String body) throws IOException {
        cors(exchange);
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(status, bytes.length == 0 ? -1 : bytes.length);
        exchange.getResponseBody().write(bytes);
        exchange.close();
    }
}
