package com.github.diegopacheco.sandboxspring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@ConfigurationProperties
public class TimestampTaskProperties {

    private String format = "yyyy-MM-dd HH:mm:ss.SSS";

    public String getFormat() {
        Assert.hasText(this.format, "format must not be empty nor null");
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}