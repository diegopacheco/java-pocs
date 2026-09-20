package com.github.diegopacheco.java27.lazyconstants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LazyConstantsTest {

    @Test
    void nothingIsComputedUntilTheConstantIsRead() {
        LazyConstants lazy = new LazyConstants();
        assertEquals(0, lazy.initializations());
    }

    @Test
    void theComputingFunctionRunsAtMostOncePerConstant() {
        LazyConstants lazy = new LazyConstants();
        assertEquals("Java 27 lazy constant", lazy.banner());
        assertEquals("Java 27 lazy constant", lazy.banner());
        assertEquals(1, lazy.initializations());
    }

    @Test
    void lazyListElementsAreInitializedIndependently() {
        LazyConstants lazy = new LazyConstants();
        assertEquals(9, lazy.square(3));
        assertEquals(9, lazy.square(3));
        assertEquals(1, lazy.initializations());
        assertEquals(16, lazy.square(4));
        assertEquals(2, lazy.initializations());
    }

    @Test
    void lazyMapComputesOnlyTheKeysThatAreRead() {
        LazyConstants lazy = new LazyConstants();
        assertEquals(8, lazy.width("constant"));
        assertEquals(8, lazy.width("constant"));
        assertEquals(1, lazy.initializations());
    }

    @Test
    void lazySetComputesMembershipOnDemandAndCachesIt() {
        LazyConstants lazy = new LazyConstants();
        assertTrue(lazy.isEnabled(LazyConstants.Option.VERBOSE));
        assertFalse(lazy.isEnabled(LazyConstants.Option.DRY_RUN));
        assertEquals(2, lazy.initializations());
        assertTrue(lazy.isEnabled(LazyConstants.Option.VERBOSE));
        assertEquals(2, lazy.initializations());
    }
}
