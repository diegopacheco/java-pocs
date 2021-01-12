package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	HelloService service;

	@RequestMapping("/")
	public String index() {
		return service.getGreetings("Dear friend");
	}

	@RequestMapping("/err")
	public String indexError() {
		return service.getGreetings(null);
	}

}

