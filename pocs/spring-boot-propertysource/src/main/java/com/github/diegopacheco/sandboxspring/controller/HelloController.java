package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@Value("${answer}")
	String answer;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot 3x! Answer is: " + answer;
	}

}

