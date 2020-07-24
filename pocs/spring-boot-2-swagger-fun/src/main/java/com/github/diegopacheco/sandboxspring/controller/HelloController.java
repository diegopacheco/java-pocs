package com.github.diegopacheco.sandboxspring.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@ApiOperation(value = "Greetings",notes = "It is what it is!")
	@RequestMapping("/")
	@GetMapping
	public String index() {
		return "Greetings from Spring Boot!";
	}

}

