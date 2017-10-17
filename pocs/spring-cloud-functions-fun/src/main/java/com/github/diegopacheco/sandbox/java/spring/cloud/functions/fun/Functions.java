package com.github.diegopacheco.sandbox.java.spring.cloud.functions.fun;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionScan;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

@FunctionScan
@SpringBootApplication
public class Functions {
	
	@Bean
	public Function<Flux<String>, Flux<String>> lower() {
		return flux -> flux.map(value -> value.toLowerCase());
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Functions.class, args);
	}
	
}
