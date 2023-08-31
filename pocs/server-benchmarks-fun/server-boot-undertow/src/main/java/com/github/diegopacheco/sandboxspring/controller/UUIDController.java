package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UUIDController {

	@RequestMapping("/")
	public String index() {
		return UUID.randomUUID().toString();
	}

}

