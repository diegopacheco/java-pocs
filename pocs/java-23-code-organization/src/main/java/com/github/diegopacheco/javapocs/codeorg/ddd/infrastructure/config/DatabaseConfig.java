package com.github.diegopacheco.javapocs.codeorg.ddd.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories(basePackages = "com.github.diegopacheco.javapocs.codeorg.ddd.infrastructure.persistence")
public class DatabaseConfig {
}