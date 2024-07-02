package com.github.diegopacheco.sandboxspring.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.ExtractingResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    @Bean
    public HttpClient httpClient() {
        var connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(1);
        connectionManager.setDefaultMaxPerRoute(1);

        var reqConfig = RequestConfig.custom().build();

        return HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(reqConfig)
                .build();
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate rt = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        rt.setErrorHandler(new ExtractingResponseErrorHandler());
        return rt;
    }

}