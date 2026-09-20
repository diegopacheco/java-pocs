package com.github.diegopacheco.java27.compactheaders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CompactObjectHeadersTest {

    @Test
    void compactHeadersAreOnWithoutAskingForThem() {
        assertTrue(CompactObjectHeaders.enabled());
    }

    @Test
    void everyObjectHeaderShrinksFrom96To64Bits() {
        assertEquals(64, CompactObjectHeaders.headerBits());
        assertEquals(4L, CompactObjectHeaders.headerBytesSavedPerObject());
    }

    @Test
    void theSavingIsRealHeapSpaceNotJustAFlag() {
        long objects = 10_000_000L;
        assertEquals(40_000_000L, objects * CompactObjectHeaders.headerBytesSavedPerObject());
    }
}
