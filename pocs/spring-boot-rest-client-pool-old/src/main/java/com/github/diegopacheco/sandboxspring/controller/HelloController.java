package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@RestController
public class HelloController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/slow")
	public String callSlow() {
		return restTemplate.
				getForEntity("http://127.0.0.1:5000/slow", String.class)
				.getBody();
	}

}

