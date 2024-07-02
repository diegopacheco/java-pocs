package com.github.diegopacheco.sandboxspring.config;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.DefaultHttpRequestRetryStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    @Bean
    public CloseableHttpClient httpClient() {
        var connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
                .setMaxConnPerRoute(1)
                .setMaxConnTotal(1)
                .setDefaultSocketConfig(
                        SocketConfig.custom().setSoTimeout(Timeout.ofSeconds(2)).build()
                )
                .build();

        var reqConfig = RequestConfig.custom()
                //.setConnectionRequestTimeout(Timeout.ofSeconds(10))
                //.setConnectTimeout(Timeout.ofSeconds(1))
                .build();

        return HttpClients.custom()
                .setRetryStrategy(new DefaultHttpRequestRetryStrategy(3, TimeValue.ofSeconds(1)))
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(reqConfig)
                .setConnectionManagerShared(true)
                .build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient()));
    }

}