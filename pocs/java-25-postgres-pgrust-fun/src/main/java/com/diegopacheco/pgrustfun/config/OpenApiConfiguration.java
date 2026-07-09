package com.diegopacheco.pgrustfun.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    OpenAPI booksApi() {
        return new OpenAPI().info(new Info()
                .title("Books API on pgrust")
                .version("1.0.0")
                .description("Spring Boot 4.0.6, Spring Data JDBC, HikariCP and pgrust"));
    }
}

