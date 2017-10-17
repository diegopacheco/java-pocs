package com.blogspot.diegopacheco.spring.jndi.service;

import java.io.Serializable;
import java.util.Date;

public class SystemDateServiceImpl implements DateService, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public String getCurrentDateTime() {
		return new Date().toString();
	}
	
}
