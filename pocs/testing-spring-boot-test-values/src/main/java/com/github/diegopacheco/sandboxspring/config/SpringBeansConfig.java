package com.github.diegopacheco.sandboxspring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeansConfig {

    @Value("${greet:hi}")
    String greet;

    @Bean(value = "message")
    public String greetings(){
        return greet + " my friend!";
    }

}
