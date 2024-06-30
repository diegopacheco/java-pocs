package com.github.diegopacheco.sandboxspring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@Configuration
@PropertySources({
        @PropertySource("file:external.properties")
})
public class SpringConfig {
}
