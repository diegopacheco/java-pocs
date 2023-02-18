package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Try: /works, /api/admin/ok, /api/user/ok ";
	}

	@RequestMapping("/api/admin/ok")
	public String adminOnly() {
		return "Admin only! Works!";
	}

	@RequestMapping("/api/user/ok")
	public String userOnly() {
		return "User only! Works!";
	}

	@RequestMapping("/works")
	public String works() {
		return "Greetings from Spring Boot! Spring Security let me pass";
	}

}

