package com.github.diegopacheco.sandboxspring.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamicConfig {

    @Bean
    @ConditionalOnClass(name = "org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer")
    public Server getTomcat(){
        return Server.TOMCAT;
    }

    @Bean
    @ConditionalOnClass(name = "reactor.netty.tcp.TcpServer")
    public Server getNetty(){
        return Server.NETTY;
    }

}
