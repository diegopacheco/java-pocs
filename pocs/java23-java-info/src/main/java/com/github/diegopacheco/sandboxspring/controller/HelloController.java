package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.config.JavaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@Autowired
	private JavaInfo javaInfo;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/info")
	public String info() {
		return javaInfo.getInfo();
	}

}

