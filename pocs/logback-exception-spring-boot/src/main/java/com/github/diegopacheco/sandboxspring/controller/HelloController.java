package com.github.diegopacheco.sandboxspring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/error")
	public String error() {
		Exception ex = new RuntimeException("Error fake", new RuntimeException("Error Root Fake"));
		logger.error("Accessed error endpoint",ex);
		return "error";
	}

}

