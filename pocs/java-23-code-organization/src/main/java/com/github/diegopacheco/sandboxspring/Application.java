package com.github.diegopacheco.sandboxspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication(scanBasePackages = {
    "com.github.diegopacheco.sandboxspring", 
    "com.github.diegopacheco.javapocs.codeorg.ddd"
})
@EnableAutoConfiguration
@EnableJdbcRepositories(basePackages = "com.github.diegopacheco.javapocs.codeorg.ddd.infrastructure.persistence")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Spring Boot 3.5.x working! ");
		};
	}
}

