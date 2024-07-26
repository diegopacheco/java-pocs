package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.service.BadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	private final Logger LOG = LoggerFactory.getLogger(BadService.class);

	@Autowired
	private BadService badService;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/ok")
	public String ok() {
		LOG.info("calling ok");
		badService.ok();
		return "ok";
	}

	@RequestMapping("/error")
	public String error() {
		LOG.info("calling error");
		badService.error();
		return "error";
	}

}

