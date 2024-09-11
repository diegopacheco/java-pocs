package com.github.diegopacheco.sandboxspring.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class NoBlockService {

    public String getDate() {
        return new Date().toString();
    }

    public Mono<String> getDateAsync() {
        return Mono.fromCallable( () -> {
            return new Date().toString();
        });
    }

}
