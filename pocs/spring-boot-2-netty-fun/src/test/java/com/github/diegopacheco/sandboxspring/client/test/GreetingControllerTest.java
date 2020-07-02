package com.github.diegopacheco.sandboxspring.client.test;

import com.github.diegopacheco.sandboxspring.Application;
import com.github.diegopacheco.sandboxspring.client.GreetingWebClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private GreetingWebClient greetingWebClient;

    @Test
    public void testGreetOption1() {
        webTestClient
                .get().uri("/greet/Diego")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Greeting Diego");
    }

    @Test
    public void testGreetOption2() {
        Application.main(new String[]{});
        String result = greetingWebClient.greet("Diego");
        assertEquals("Greeting Diego", result);
    }

}
