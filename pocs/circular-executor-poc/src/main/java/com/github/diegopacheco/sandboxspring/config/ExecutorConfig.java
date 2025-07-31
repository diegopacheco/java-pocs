package com.github.diegopacheco.sandboxspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ExecutorConfig {

    @Bean
    public ExecutorService getExecutor() {
        int initThreadPoolSize = 10;
        int maxThreadPoolSize = 20;
        int keepAliveTime = 60;
        int maxQueueSize = 2000;
        return new ThreadPoolExecutor(
                initThreadPoolSize,
                maxThreadPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(maxQueueSize)
        );
    }

}
