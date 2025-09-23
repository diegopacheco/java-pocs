package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Set;
import java.util.Map;

@RestController
public class SessionController {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	private FindByIndexNameSessionRepository<? extends Session> sessionRepository;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot with Spring Session Redis!";
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

	@GetMapping("/session/info")
	public String getSessionInfo(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Session springSession = sessionRepository.findById(session.getId());
			if (springSession != null) {
				return "Session ID: " + session.getId() +
				       ", Creation Time: " + springSession.getCreationTime() +
				       ", Last Accessed: " + springSession.getLastAccessedTime() +
				       ", Max Inactive: " + springSession.getMaxInactiveInterval();
			}
		}
		return "No session found";
	}

}

