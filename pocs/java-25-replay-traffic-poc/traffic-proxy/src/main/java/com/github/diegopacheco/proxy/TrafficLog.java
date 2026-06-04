package com.github.diegopacheco.proxy;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public final class TrafficLog {

    private final Path path;
    private final Object lock = new Object();
    private final AtomicLong count = new AtomicLong();

    public TrafficLog(Path path) {
        this.path = path;
        if (Files.exists(path)) {
            try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
                count.set(lines.filter(l -> !l.isBlank()).count());
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }

    public Path path() {
        return path;
    }

    public long count() {
        return count.get();
    }

    public void append(LogEntry entry) {
        synchronized (lock) {
            try {
                Files.writeString(path, entry.toJson() + System.lineSeparator(), StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                count.incrementAndGet();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }

    public List<LogEntry> read() {
        synchronized (lock) {
            if (!Files.exists(path)) {
                return List.of();
            }
            try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
                List<LogEntry> out = new ArrayList<>();
                lines.filter(l -> !l.isBlank()).forEach(l -> out.add(LogEntry.fromJson(l)));
                return out;
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }
}
