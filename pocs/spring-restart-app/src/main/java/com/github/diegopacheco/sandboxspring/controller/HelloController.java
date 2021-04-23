package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		System.out.println("index called!");
		return "Greetings from Spring Boot!";
	}

}

