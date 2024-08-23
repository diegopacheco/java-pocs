package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.drivers.CatFactsDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RestController
public class MainController {

	@Autowired
	private CatFactsDriver catFactDriver;

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

	@RequestMapping("/fact")
	public String fact(){
		return catFactDriver.getFact();
	}

	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {}
	}

}

