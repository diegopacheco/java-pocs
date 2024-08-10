package com.github.diegopacheco.sandboxspring.config;

import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.netty.channel.MicrometerChannelMetricsRecorder;

@Configuration
public class NettyWebFluxConfig {

    @Bean
    public NettyServerCustomizer nettyServerCustomizer() {
        return httpServer -> httpServer.metrics(true, () -> new MicrometerChannelMetricsRecorder("MY_SERVICE", "MY_SERVICE"));
    }

}
