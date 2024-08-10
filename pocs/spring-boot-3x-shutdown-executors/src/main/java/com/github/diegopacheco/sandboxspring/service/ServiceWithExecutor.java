package com.github.diegopacheco.sandboxspring.service;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ServiceWithExecutor {

    private final ExecutorService executorPool3 = Executors.newCachedThreadPool();

    @PreDestroy
    void shutdownExecutor(){
        System.out.println("Shutting down executorPool3");
        executorPool3.shutdownNow();
        executorPool3.close();
        System.out.println("Shutting down executorPool3 DONE");
    }

}
