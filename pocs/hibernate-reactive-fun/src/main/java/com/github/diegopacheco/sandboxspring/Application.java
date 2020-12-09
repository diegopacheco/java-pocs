package com.github.diegopacheco.sandboxspring;

import com.github.diegopacheco.sandboxspring.dao.ThingDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.transaction.Transactional;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.github.diegopacheco.sandboxspring")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private ThingDao dao;

	@Bean
	@Transactional
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			dao.createThing("Diego");
			System.out.println("Spring Boot 2.0 working with Hibernate 5.x! ");
		};
	}
}

