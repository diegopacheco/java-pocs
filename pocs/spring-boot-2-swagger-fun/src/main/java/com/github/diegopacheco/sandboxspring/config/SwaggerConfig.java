package com.github.diegopacheco.sandboxspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

//@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.github.diegopacheco.sandboxspring.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("My REST API",
                "Some custom description of API.", "API TOS", "Terms of service",
                new Contact("John Doe", "www.example.com", "myeaddress@company.com"),
                "License of API", "API license URL", Collections.emptyList());
        return apiInfo;
    }
}