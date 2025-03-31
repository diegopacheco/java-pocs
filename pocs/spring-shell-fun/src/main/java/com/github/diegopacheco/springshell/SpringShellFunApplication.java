package com.github.diegopacheco.springshell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.github.diegopacheco.springshell")
public class SpringShellFunApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringShellFunApplication.class, args);
	}

}
