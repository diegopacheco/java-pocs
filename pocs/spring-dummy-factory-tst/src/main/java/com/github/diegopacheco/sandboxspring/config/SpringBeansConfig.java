package com.github.diegopacheco.sandboxspring.config;

import com.github.diegopacheco.sandboxspring.factory.DummyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeansConfig {

    @Bean
    public DummyFactory dummyFactory(){
        return DummyFactory.create();
    }

}
