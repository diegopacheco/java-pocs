package com.github.diegopacheco.proxy;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LogFormatTest {

    @Test
    void jsonRoundTripPreservesSpecialCharacters() {
        String tricky = "line1\nline2 \"quoted\" \\slash\\ and {\"json\":true}";
        String encoded = Json.str(tricky);
        Object decoded = Json.parse(encoded);
        assertEquals(tricky, decoded);
    }

    @Test
    void capturedRequestSurvivesWriteAndReadSoReplayStaysFaithful() throws Exception {
        Path file = Files.createTempFile("traffic", ".log");
        Files.deleteIfExists(file);
        TrafficLog log = new TrafficLog(file);

        LogEntry put = new LogEntry("2026-06-03T10:00:00Z", "PUT", "/books/9", 201, 7,
                "{\"title\":\"A \\\"weird\\\" title\",\"author\":\"x\"}", "{\"id\":9}");
        LogEntry get = new LogEntry("2026-06-03T10:00:01Z", "GET", "/books/9?with=query", 200, 3, "", "{\"id\":9}");
        log.append(put);
        log.append(get);

        List<LogEntry> read = new TrafficLog(file).read();
        assertEquals(2, read.size());
        assertEquals(put, read.get(0));
        assertEquals(get, read.get(1));
        assertEquals(2L, new TrafficLog(file).count());
        assertTrue(read.get(1).path().contains("?with=query"));

        Files.deleteIfExists(file);
    }
}
