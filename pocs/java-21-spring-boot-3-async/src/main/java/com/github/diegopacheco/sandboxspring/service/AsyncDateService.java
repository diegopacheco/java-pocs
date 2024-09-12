package com.github.diegopacheco.sandboxspring.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncDateService {

    @Async("taskExecutor")
    public CompletableFuture<String> getDateAsync() {
        // Simulate a long-running task
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return CompletableFuture.completedFuture(new Date().toString());
    }

    @Async("taskExecutor")
    public CompletableFuture<String> getDateAsyncReallyAsync() {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running task
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return new Date().toString();
        });
    }

}