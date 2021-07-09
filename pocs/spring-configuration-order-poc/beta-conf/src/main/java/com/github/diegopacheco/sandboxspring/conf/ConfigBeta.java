package com.github.diegopacheco.sandboxspring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ConfigBeta {

    @Component
    public static class Beta{}

    @Bean
    public Beta getBeta(){
        System.out.println("[ConfigBeta] loading Beta... " + System.nanoTime());
        return new Beta();
    }

}
