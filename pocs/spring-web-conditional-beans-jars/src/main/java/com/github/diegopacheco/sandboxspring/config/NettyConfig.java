package com.github.diegopacheco.sandboxspring.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(name = "reactor.netty.tcp.TcpServer")
public class NettyConfig {
    @Bean
    public Server getNetty() {
        return Server.NETTY;
    }
}
