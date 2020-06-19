package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(GreetingController.class)
public class GreetingControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    private GreetingService greetingService;

    @Test
    public void testGreetNameWithMocks() {
        Mono<String> resultMono = Mono.just("Greeting Diego");
        when(greetingService.greet("Diego")).thenReturn(resultMono);

        webTestClient.get()
                .uri("/greet/Diego")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(result1 -> result1, equalTo("Greeting Diego"));
    }

}
