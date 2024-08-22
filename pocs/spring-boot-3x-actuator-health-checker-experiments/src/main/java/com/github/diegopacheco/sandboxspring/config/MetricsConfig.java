package com.github.diegopacheco.sandboxspring.config;

import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import reactor.netty.channel.MicrometerChannelMetricsRecorder;
import reactor.netty.http.client.HttpClient;

@Configuration
public class MetricsConfig {

    @Bean
    public NettyServerCustomizer nettyServerCustomizer() {
        return httpServer -> httpServer.metrics(true, () -> new MicrometerChannelMetricsRecorder("MY_SERVICE", "MY_SERVICE"));
    }

    @Bean
    public ReactorClientHttpConnector getReactorClientHttpConnector() {
        return new ReactorClientHttpConnector(
                HttpClient.create().wiretap(true).
                        metrics(true, () ->
                                new MicrometerChannelMetricsRecorder("myservicename", "myservicename")));
    }

}
