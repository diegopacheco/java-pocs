package com.github.diegopacheco.java27.structuredconcurrency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.github.diegopacheco.java27.structuredconcurrency.StructuredConcurrency.Order;
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.Test;

class StructuredConcurrencyTest {

    @Test
    void subtasksRunConcurrentlyAndTheirResultsKeepForkOrder() throws Exception {
        Order order = StructuredConcurrency.load("diego", "book");
        assertEquals(new Order("user:diego", "item:book"), order);
    }

    @Test
    void oneFailingSubtaskCancelsTheScopeAndSurfacesTheFailure() {
        ExecutionException thrown = assertThrows(ExecutionException.class,
                () -> StructuredConcurrency.load("diego", ""));
        assertInstanceOf(IllegalArgumentException.class, thrown.getCause());
        assertEquals("missing item", thrown.getCause().getMessage());
    }

    @Test
    void joinCanThrowADomainExceptionChosenByTheCaller() {
        OrderFailedException thrown = assertThrows(OrderFailedException.class,
                () -> StructuredConcurrency.loadOrFail("", "book"));
        assertInstanceOf(IllegalArgumentException.class, thrown.getCause());
        assertEquals("missing user", thrown.getCause().getMessage());
    }

    @Test
    void anySuccessfulOrThrowReturnsTheFirstSubtaskToFinish() throws Exception {
        String winner = StructuredConcurrency.fastest(Duration.ofSeconds(5), "cache", "replica", "origin");
        assertEquals("cache", winner);
    }
}
