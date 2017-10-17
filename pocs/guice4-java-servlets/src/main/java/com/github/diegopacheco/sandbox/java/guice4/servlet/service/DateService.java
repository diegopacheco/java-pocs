package com.github.diegopacheco.sandbox.java.guice4.servlet.service;

import java.util.Date;

import javax.inject.Singleton;

@Singleton
public class DateService {
	
	public String getDate(){
		return new Date().toString();
	}
	
}
