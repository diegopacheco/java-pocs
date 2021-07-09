package com.github.diegopacheco.sandboxspring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
//@Priority(1)
public class ConfigOne {

    @Component
    public static class One{}

    @Bean
    public One getOne(){
        System.out.println("[ConfigOne] loading One... " + System.nanoTime());
        return new One();
    }

}
