package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/math/sum/{va}/{vb}")
	public String sum(@PathVariable("va") String va, @PathVariable("vb") String vb) {
		System.out.println("VA + " + va + " VB: " + vb);
		Double result = Double.parseDouble(va) + Double.parseDouble(vb);
		return new String(result+"");
	}

}

