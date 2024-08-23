package com.github.diegopacheco.sandboxspring.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.java11.instrument.binder.jdk.MicrometerHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.net.http.HttpClient;

@Configuration
public class HttpClientConfig {

    private final MeterRegistry meterRegistry;

    public HttpClientConfig(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Bean
    public HttpClient getInstrumentedClient(){
        HttpClient client = MicrometerHttpClient.instrumentationBuilder(httpClient(), meterRegistry).build();
        return client;
    }

    private HttpClient httpClient() {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
        return client;
    }

}
