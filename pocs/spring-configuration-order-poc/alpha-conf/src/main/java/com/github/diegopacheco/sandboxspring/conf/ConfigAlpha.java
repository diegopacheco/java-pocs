package com.github.diegopacheco.sandboxspring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

@Configuration
public class ConfigAlpha {

    @Component
    public static class Alpha{}

    @Bean
    public Alpha getAlpha(){
        System.out.println("[ConfigAlpha] loading Alpha... " + System.nanoTime());
        return new Alpha();
    }

}
