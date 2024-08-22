package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RestController
public class MainController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/slow/{time}")
	public String slowMs(@PathVariable(value = "time") String time) {
		long start = System.currentTimeMillis();
		if (null == time || time.isEmpty()) {
			time = "1";
		}

		sleep(Integer.parseInt(time));
		String result = UUID.randomUUID().toString();
		long end = System.currentTimeMillis();

		return """
           {
               "result": "%s",
               "time": "%s ms"
           }""".formatted(result, (end - start));

	}

	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {}
	}

}

