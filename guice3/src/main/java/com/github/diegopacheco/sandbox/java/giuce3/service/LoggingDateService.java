package com.github.diegopacheco.sandbox.java.giuce3.service;

import javax.inject.Singleton;

/**
 * Logging implementation for the DateService
 * @author Diego Pacheco
 *
 */
@Singleton
public class LoggingDateService implements DateService{
	@Override
	public String currentDate() {
		String result = new java.util.Date().toString();
		System.out.println("Return date: " + result);
		return result;
	}
}
