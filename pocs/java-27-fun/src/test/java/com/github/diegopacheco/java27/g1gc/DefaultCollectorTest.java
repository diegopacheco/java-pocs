package com.github.diegopacheco.java27.g1gc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class DefaultCollectorTest {

    @Test
    void g1IsSelectedWithoutAnyCommandLineFlagEvenOnASmallMachine() {
        assertTrue(DefaultCollector.isG1(), "expected G1 but got " + DefaultCollector.names());
    }

    @Test
    void serialIsNoLongerChosenByErgonomics() {
        List<String> names = DefaultCollector.names();
        assertFalse(names.contains("Copy"));
        assertFalse(names.contains("MarkSweepCompact"));
    }

    @Test
    void theCollectorIsLiveAndReportingCounters() {
        System.gc();
        assertTrue(DefaultCollector.collections() >= 0);
    }
}
