package com.github.diegopacheco.sandboxspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class DummyService {

    @Autowired
    private Executor executor;

    /*
     * This one nothing happens.
     */
    @Async
    public CompletableFuture<String> blowIt(){
        return CompletableFuture.<String>supplyAsync( () -> {
            throw new RuntimeException("I dont like it");
        },executor);
    }

    /*
    *  This one is logged:
    *
    * Oopsy Daisy
    * Exception message - I dont like it
    * Method name - blowIt2
    *
    * */
    @Async
    public void  blowIt2(){
        throw new RuntimeException("I dont like it");
    }

}
