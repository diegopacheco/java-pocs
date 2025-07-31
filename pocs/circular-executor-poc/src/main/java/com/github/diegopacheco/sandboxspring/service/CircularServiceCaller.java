package com.github.diegopacheco.sandboxspring.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class CircularServiceCaller {

    @Autowired
    private ExecutorService ex;

    public CircularServiceCaller(ExecutorService ex){
        this.ex = ex;
    }

    public boolean enqueueWork(WorkTask task){
        CompletableFuture.supplyAsync(() -> {
            try {
                return ex.submit(task).get();
            } catch (Exception e) {
                return null;
            }
        }, ex).thenAccept(result -> {
            if (result == null) {
                System.out.println("Not done yet, so we will add to the queue and try again...");
                enqueueWork(task);
            }
        });
        return true;
    }

}
