package com.github.diegopacheco.sandboxspring.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingClass("reactor.netty.tcp.TcpServer")
public class TomcatConfig {

    @Bean
    public Server getTomcat(){
        return Server.TOMCAT;
    }
}
