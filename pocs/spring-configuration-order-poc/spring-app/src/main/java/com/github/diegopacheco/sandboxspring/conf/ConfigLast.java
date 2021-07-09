package com.github.diegopacheco.sandboxspring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

@Configuration
@Priority(100)
public class ConfigLast {

    @Component
    public static class Last{}

    @Bean
    public Last getLast(){
        System.out.println("[ConfigLast] loading Last... " + System.nanoTime());
        return new Last();
    }

}
