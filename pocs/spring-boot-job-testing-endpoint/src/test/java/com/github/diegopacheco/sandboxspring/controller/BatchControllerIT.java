package com.github.diegopacheco.sandboxspring.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *   Add to avoid watnings:
 *   -XX:+EnableDynamicAgentLoading -Djdk.instrument.traceUsage=true)
 */
@WebFluxTest(BatchController.class)
public class BatchControllerIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testTaskUUIDGeneration() {
        webTestClient.get().uri("/batch/uuid/3")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).value(content -> {
                    assertFalse(content.isEmpty());
                    assertTrue(content.contains("true"));
                });
    }

}
