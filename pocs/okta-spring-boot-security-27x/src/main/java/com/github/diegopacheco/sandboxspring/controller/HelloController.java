package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@GetMapping("/")
	public String home(@AuthenticationPrincipal OidcUser user) {
		return "Welcome, "+ user.getFullName() + "!";
	}

	@GetMapping("/secure/data")
	public String data() {
		return "Your data is { name: john, mail: john@john.com ssn: 123456789 dob: 2-2-82 } ";
	}

}

