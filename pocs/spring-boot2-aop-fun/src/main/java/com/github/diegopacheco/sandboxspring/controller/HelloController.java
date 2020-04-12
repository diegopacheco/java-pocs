package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.LogExecutionTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@RestController
public class HelloController {

	Logger logger = LogManager.getLogger(HelloController.class);

	@LogExecutionTime
	@RequestMapping("/")
	public String index() {
		return greetings();
	}

	public String greetings() {
		try{
			logger.info("Serving greetings... ");
			Thread.sleep(2000);
			return "Greetings from Spring Boot!";
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
