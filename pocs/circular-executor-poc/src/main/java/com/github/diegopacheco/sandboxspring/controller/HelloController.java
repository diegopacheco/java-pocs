package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.service.CircularServiceCaller;
import com.github.diegopacheco.sandboxspring.service.WorkTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@Autowired
	CircularServiceCaller serviceCaller;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/work")
	public String work() {
		serviceCaller.enqueueWork(new WorkTask());
		return "OK";
	}

}

