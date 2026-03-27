package com.github.diegopacheco.es.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {

    @Value("${app.index.retention-days:3}")
    private int retentionDays;

    @Value("${app.index.prefix:index}")
    private String indexPrefix;

    public int getRetentionDays() {
        return retentionDays;
    }

    public String getIndexPrefix() {
        return indexPrefix;
    }
}
