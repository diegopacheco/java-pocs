package com.github.diegopacheco.javapocs.codeorg.ddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories(basePackages = "com.github.diegopacheco.javapocs.codeorg.ddd.infrastructure.persistence")
public class DDDApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(DDDApplication.class, args);
    }
}