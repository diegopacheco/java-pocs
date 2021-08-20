package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class DateController {

	@Autowired
	DateService service;

	@RequestMapping("/date")
	public String getDate() {
		return service.getCurrentDate();
	}

}

