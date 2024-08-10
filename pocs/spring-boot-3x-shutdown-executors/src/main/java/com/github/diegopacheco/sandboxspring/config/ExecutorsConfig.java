package com.github.diegopacheco.sandboxspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ExecutorsConfig {

    @Bean(name = "executorPool1", destroyMethod = "shutdown")
    public ExecutorService executorPool1() {
        return Executors.newFixedThreadPool(10);
    }

    @Bean(name = "executorPool2")
    public ExecutorService executorPool2() {
        ExecutorService es = Executors.newFixedThreadPool(10);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down executorPool2");
            es.shutdown();
            es.close();
        }));
        return es;
    }

}
