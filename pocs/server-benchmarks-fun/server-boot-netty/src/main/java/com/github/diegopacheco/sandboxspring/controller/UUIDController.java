package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class UUIDController {

    @RequestMapping("/")
    public String index() {
        return UUID.randomUUID().toString();
    }

    @RequestMapping("/r")
    public Mono<String> reactive() {
        return Mono.just(UUID.randomUUID().toString());
    }

}

