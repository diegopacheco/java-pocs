package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/data")
	public String index() {
		return "42! mTLS.";
	}

}

