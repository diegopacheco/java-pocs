package com.github.diegopacheco.sandboxspring.config;

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NettyWebFluxConfig {

    @Bean
    public WebServerFactoryCustomizer<NettyReactiveWebServerFactory> getWebServerFactoryCustomizer() {
        WebServerFactoryCustomizer<NettyReactiveWebServerFactory> customizer = factory -> {
            factory.setPort(8080);
        };
        return customizer;
    }

}
