package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumController {

	@PostMapping(path= "/sum", consumes = "application/json", produces = "application/json")
	public String sum(@RequestBody String parameters) {
		String values[] = parameters.split(",");
		Double va = Double.parseDouble(values[0]);
		Double vb = Double.parseDouble(values[1]);
		Double result = va + vb;
		return result+"";
	}

}

