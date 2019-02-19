package com.github.diegopacheco.spring.boot.x.microservice.simplesandbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class IndexController {

	@Autowired
	private HelloWorldService helloWorldService;

	@GetMapping("/")
	@ResponseBody
	public String helloWorld() {
		return this.helloWorldService.getHelloMessage();
	}
	
}
