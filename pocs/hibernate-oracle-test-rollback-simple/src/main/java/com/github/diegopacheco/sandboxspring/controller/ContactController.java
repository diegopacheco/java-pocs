package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.dao.DBFeeder;
import com.github.diegopacheco.sandboxspring.model.Contact;
import com.github.diegopacheco.sandboxspring.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
public class ContactController {

	@Autowired
	ContactService contactService;

	@Autowired
	DBFeeder feeder;

	@RequestMapping("/all")
	@ResponseBody
	public List<Contact> getAllContacts() {
		return contactService.list();
	}

	@RequestMapping("/insert")
	public void insert10() {
		feeder.feedData();
	}

}