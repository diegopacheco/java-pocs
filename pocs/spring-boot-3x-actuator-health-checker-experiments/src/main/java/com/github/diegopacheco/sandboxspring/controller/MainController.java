package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/slow/{time}")
	public String slowOneSec(@PathVariable(value = "time") String time) {
		if (null == time || time.isEmpty()) {
			time = "1";
		}
		sleep(Integer.parseInt(time));
		return UUID.randomUUID().toString();
	}

	private void sleep(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {}
	}

}

