package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.factory.DummyFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@RestController
public class HelloController {

	@Inject
	DummyFactory dm;

	@RequestMapping("/")
	public String index() {
		dm.getLs().info("does this work?");
		return "Greetings from Spring Boot! Date: " + dm.getDs().getDate();
	}

}

