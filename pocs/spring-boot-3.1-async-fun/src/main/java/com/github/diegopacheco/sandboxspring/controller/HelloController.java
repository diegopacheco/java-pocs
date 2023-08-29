package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

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
			System.out.println("Execute method asynchronously. " + Thread.currentThread().getName());
			Thread.sleep(5L);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}

