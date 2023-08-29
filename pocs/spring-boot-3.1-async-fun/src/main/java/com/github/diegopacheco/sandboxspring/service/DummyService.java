package com.github.diegopacheco.sandboxspring.service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class DummyService {

    @Async
    public CompletableFuture<String> blowIt(){
        return CompletableFuture.<String>failedFuture(new RuntimeException("I dont like it"));
    }

}
