package com.github.diegopacheco.sandboxspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class NettyConfig {

    @Bean
    public NettyServerCustomizerConfiguration nettyServerCustomizerConfiguration() {
        System.out.println("NettyConfig invoked! ");
        return new NettyServerCustomizerConfiguration();
    }

}
