package com.github.diegopacheco.sandboxspring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.github.diegopacheco.sandboxspring.dao")
public class ElasticsearchConfig extends ElasticsearchConfiguration {

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .withBasicAuth("elastic", "changeme") // Default credentials
                .withSocketTimeout(10000) // Increase timeouts
                .withConnectTimeout(5000)
                .build();
    }
}