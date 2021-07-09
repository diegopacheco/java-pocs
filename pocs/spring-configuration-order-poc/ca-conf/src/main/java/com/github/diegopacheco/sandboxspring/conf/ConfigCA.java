package com.github.diegopacheco.sandboxspring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ConfigCA {

    @Component
    public static class CA{}

    @Bean
    public CA getCA(){
        System.out.println("[ConfigCA] loading CA... " + System.nanoTime());
        return new CA();
    }

}
