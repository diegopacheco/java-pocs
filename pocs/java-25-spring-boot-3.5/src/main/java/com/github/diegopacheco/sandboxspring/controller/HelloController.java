package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @Value("${java.version}")
    private String javaVersion;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot 3.5.5! Running Java " + javaVersion;
	}

}

