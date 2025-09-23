package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Set;

@RestController
public class SessionController {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot with Spring Session!";
	}

	@PostMapping("/session")
	public String createSession(@RequestParam String key, @RequestParam String value, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute(key, value);
		return "Session created with ID: " + session.getId();
	}

	@GetMapping("/session")
	public String getSession(@RequestParam String key, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Object value = session.getAttribute(key);
			return "Session ID: " + session.getId() + ", Key: " + key + ", Value: " + value;
		}
		return "No session found";
	}

	@GetMapping("/sessions")
	public Set<String> getActiveSessions() {
		return redisTemplate.keys("spring:session:sessions:*");
	}

}

