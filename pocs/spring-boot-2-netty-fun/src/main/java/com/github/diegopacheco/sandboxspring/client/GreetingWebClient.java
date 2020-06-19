package com.github.diegopacheco.sandboxspring.client;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class GreetingWebClient {

    private WebClient client = WebClient.create("http://localhost:8080");

    public String greet(String name) {
        Mono<ClientResponse> result = client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/greet/{name}")
                        .build(name)
                )
                .accept(MediaType.TEXT_PLAIN)
                .exchange();
        return  result.flatMap(res -> res.bodyToMono(String.class)).block();
    }

}
