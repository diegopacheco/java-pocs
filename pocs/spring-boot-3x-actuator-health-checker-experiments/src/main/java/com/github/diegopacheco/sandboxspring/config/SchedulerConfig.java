package com.github.diegopacheco.sandboxspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Configuration
public class SchedulerConfig {

    /*
    @Bean
    @Order(1)
    public Scheduler originalScheduler() {
        return Schedulers.newBoundedElastic(10, 1000, "customSchedulerBE");
    }
     */
}