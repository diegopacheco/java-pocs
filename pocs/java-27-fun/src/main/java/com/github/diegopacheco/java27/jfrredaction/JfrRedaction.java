package com.github.diegopacheco.java27.jfrredaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import jdk.jfr.Recording;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;

public final class JfrRedaction {

    public static final String REDACTED = "[REDACTED]";

    public static Map<String, String> initialSystemProperties() throws IOException {
        Path dump = Files.createTempFile("jep536", ".jfr");
        try (Recording recording = new Recording()) {
            recording.enable("jdk.InitialSystemProperty");
            recording.start();
            recording.stop();
            recording.dump(dump);
        }
        try {
            Map<String, String> properties = new LinkedHashMap<>();
            for (RecordedEvent event : RecordingFile.readAllEvents(dump)) {
                properties.put(event.getString("key"), event.getString("value"));
            }
            return properties;
        } finally {
            Files.deleteIfExists(dump);
        }
    }

    public static boolean isRedacted(String key) throws IOException {
        return REDACTED.equals(initialSystemProperties().get(key));
    }
}
