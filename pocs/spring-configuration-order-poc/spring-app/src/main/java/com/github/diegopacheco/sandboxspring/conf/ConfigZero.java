package com.github.diegopacheco.sandboxspring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

@Configuration
@Priority(0)
public class ConfigZero {

    @Component
    public static class Zero{}

    @Bean
    public Zero getZero(){
        System.out.println("[ConfigZero] loading Zero... " + System.nanoTime());
        return new Zero();
    }

}
