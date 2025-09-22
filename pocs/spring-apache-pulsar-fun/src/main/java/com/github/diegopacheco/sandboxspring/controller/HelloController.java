package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.service.PulsarConsumerService;
import com.github.diegopacheco.sandboxspring.service.PulsarProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

	@Autowired
	private PulsarProducerService producerService;

	@Autowired
	private PulsarConsumerService consumerService;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot with Apache Pulsar!";
	}

	@PostMapping("/send")
	public String sendMessage(@RequestParam String message) {
		producerService.sendMessage("test-topic", message);
		return "Message sent: " + message;
	}

	@GetMapping("/messages")
	public List<String> getMessages() {
		return consumerService.getReceivedMessages();
	}

	@DeleteMapping("/messages")
	public String clearMessages() {
		consumerService.clearMessages();
		return "Messages cleared";
	}
}

