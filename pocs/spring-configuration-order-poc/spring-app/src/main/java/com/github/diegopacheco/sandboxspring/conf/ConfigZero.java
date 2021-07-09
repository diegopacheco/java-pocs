package com.github.diegopacheco.sandboxspring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
//@Priority(0)
public class ConfigZero {

    @Component
    //@Order(0)
    public static class Zero{}

    @Bean
    //@Qualifier
    //@Order(0)
    public Zero getZero(){
        System.out.println("[ConfigZero] loading Zero... " + System.nanoTime());
        return new Zero();
    }

}
