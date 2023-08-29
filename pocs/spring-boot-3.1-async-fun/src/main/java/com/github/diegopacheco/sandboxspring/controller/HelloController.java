package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Duration;
import java.time.Instant;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		asyncMethodWithVoidReturnType();
		return "Greetings from Spring Boot!";
	}

	@Async
	public void asyncMethodWithVoidReturnType() {
		try{
			Instant start = Instant.now();
			System.out.println("Execute method asynchronously. " + Thread.currentThread().getName());
			Thread.sleep(5000L);
			Instant end = Instant.now();
			System.out.println("Execution done: " + Duration.between(start,end).toMillis() + " ms");
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	

}

