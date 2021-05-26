package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "goto: http://localhost:8080/actuator/mappings";
	}

	@RequestMapping("/v1/api/a")
	public String getA() {
		return "Greetings from Spring Boot! v1";
	}

	@RequestMapping("/v2/api/b")
	public String getB() {
		return "Greetings from Spring Boot! v2";
	}

	@RequestMapping("/v3/api/c")
	public String getC() {
		return "Greetings from Spring Boot! v3";
	}


}

