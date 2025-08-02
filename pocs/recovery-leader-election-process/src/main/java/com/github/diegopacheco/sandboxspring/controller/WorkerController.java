package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.conf.SlotHolder;
import com.github.diegopacheco.sandboxspring.service.DataGenerationService;
import com.github.diegopacheco.sandboxspring.service.ServiceWorkSplitter;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@RestController
public class WorkerController {

	@Autowired
	DataGenerationService dataGenerationService;

	@Autowired
	ServiceWorkSplitter splitter;

	@Autowired
	SlotHolder slotHolder;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/generate")
	public String generate() {
		dataGenerationService.generate(100);
		return "done";
	}

	@RequestMapping("/ids")
	public String ids() {
		return Arrays.toString(splitter.getMyWorkIDS(slotHolder.getSlot().toString()).toArray());
	}

}

