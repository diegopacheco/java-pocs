package com.github.diegopacheco.sandboxspring.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.Date;

@Service
public class AsyncMonoService {

    public Mono<String> getDateAsync() {
        return Mono.fromCallable( () -> {
            try {
                // Simulate a long-running task
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return new Date().toString();
        });
    }

}