package com.github.diegopacheco.sandboxspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import javax.naming.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.github.diegopacheco.sandboxspring")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Spring Boot 2.0 working! ");
		};
	}

	@EventListener
	public void printConfigs(ContextRefreshedEvent event){
		ConfigurableEnvironment env = (ConfigurableEnvironment) event.getApplicationContext().getEnvironment();
		System.out.println("************************* ACTIVE APP PROPERTIES ******************************");
		List<MapPropertySource> propertySources = new ArrayList<>();

		env.getPropertySources().forEach(it -> {
			if (it instanceof MapPropertySource) {
				propertySources.add((MapPropertySource) it);
			}
		});

		propertySources.stream()
				.map(propertySource -> propertySource.getSource().keySet())
				.flatMap(Collection::stream)
				.distinct()
				.sorted()
				.forEach(key -> {
					try {
						System.out.println(key + "=" + env.getProperty(key));
					} catch (Exception e) {
						System.out.println(String.format("%s -> %s", key, e.getMessage()));
					}
				});
		System.out.println("******************************************************************************");
	}
}

