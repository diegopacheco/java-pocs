package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.service.CapitalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CapitalsController {

	@Autowired
	CapitalsService service;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot 2.6.6!";
	}

	@RequestMapping("/capital")
	@ResponseBody
	public String getCapital(@RequestParam("state") String state) {
		return service.getCapital(state);
	}


}

