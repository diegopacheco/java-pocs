package com.github.diegopacheco.proxy;

import java.util.LinkedHashMap;
import java.util.Map;

public record LogEntry(
        String ts,
        String method,
        String path,
        int status,
        long durationMs,
        String reqBody,
        String respBody) {

    public Map<String, Object> toMap() {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("ts", ts);
        m.put("method", method);
        m.put("path", path);
        m.put("status", status);
        m.put("durationMs", durationMs);
        m.put("reqBody", reqBody);
        m.put("respBody", respBody);
        return m;
    }

    public String toJson() {
        return Json.write(toMap());
    }

    public static LogEntry fromJson(String line) {
        Map<String, Object> m = Json.parseObject(line);
        return new LogEntry(
                (String) m.get("ts"),
                (String) m.get("method"),
                (String) m.get("path"),
                ((Number) m.get("status")).intValue(),
                ((Number) m.get("durationMs")).longValue(),
                (String) m.getOrDefault("reqBody", ""),
                (String) m.getOrDefault("respBody", ""));
    }
}
