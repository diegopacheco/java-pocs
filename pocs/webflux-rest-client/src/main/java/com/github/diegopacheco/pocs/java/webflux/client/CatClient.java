package com.github.diegopacheco.pocs.java.webflux.client;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Locale;

@Service
public class CatClient {

    private final WebClient client;

    public CatClient(WebClient.Builder builder) {
        this.client = builder.
                baseUrl("https://catfact.ninja").
                 filters(exchangeFilterFunctions -> {
                      exchangeFilterFunctions.add(logRequest());
                      exchangeFilterFunctions.add(logResponse());
                 }).
                build();
    }

    private ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(request -> {
                StringBuilder sb = new StringBuilder(">>> Request: \n");
                sb.append("url: " + request.url() + "\n");
                sb.append("headers:\n");
                request
                        .headers()
                        .forEach((name, values) -> values.forEach(value -> sb.append("key: " + name + " value: " + value + "\n")));
            System.out.println(sb.toString());
            return Mono.just(request);
        });
    }
    private ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(response -> {
            StringBuilder sb = new StringBuilder("<<< Response: \n");
            sb.append("status: " + response.statusCode() + "\n");
            sb.append("headers:\n");
            response
                    .headers()
                    .asHttpHeaders()
                    .forEach((name, values) -> values.forEach(value -> sb.append("key: " + name + " value: " + value + "\n")));
            System.out.println(sb.toString());
            return Mono.just(response);
        });
    }

    public Mono<String> getFact() {
        return this.client.get().uri("/fact").
                accept(MediaType.APPLICATION_JSON).
                headers(httpHeaders -> {
                    httpHeaders.setCacheControl("max-age=604800");
                    httpHeaders.setContentLanguage(Locale.ENGLISH);
                }).
                retrieve().
                bodyToMono(Fact.class).
                map(Fact::getFact);
    }

}
