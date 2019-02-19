package com.github.diegopacheco.spring.boot.x.microservice.simplesandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SimpleSandboxApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(SimpleSandboxApplication.class, args);
	}

}
