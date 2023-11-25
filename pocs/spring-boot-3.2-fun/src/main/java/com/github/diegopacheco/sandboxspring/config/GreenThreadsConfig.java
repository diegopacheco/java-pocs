package com.github.diegopacheco.sandboxspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class GreenThreadsConfig {

    @Bean
    public ExecutorService getES(){
        return Executors.newVirtualThreadPerTaskExecutor();
    }

}
