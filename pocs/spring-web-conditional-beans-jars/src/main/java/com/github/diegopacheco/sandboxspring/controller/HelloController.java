package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.config.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@Autowired
	Server serverRunning;

	@RequestMapping("/")
	public String index() {
		return "Server running is: " + serverRunning;
	}

}

