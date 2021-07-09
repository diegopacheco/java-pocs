package com.github.diegopacheco.sandboxspring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ConfigCB {

    @Component
    public static class CB{}

    @Bean
    public CB getCB(){
        System.out.println("[ConfigCB] loading CB... " + System.nanoTime());
        return new CB();
    }

}
