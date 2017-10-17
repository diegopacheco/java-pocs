package com.github.diegopacheco.sandbox.java.spring4.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.github.diegopacheco.sandbox.java.spring4.annotation")
public class AppConfig {

	@Bean
	public HelloService helloService() {
		HelloService hs = new HelloService();
		hs.setMessage("Hello from Annotations");
		return hs;
	}

}
