package com.github.diegopacheco.sandbox.java.giuce3.service;

/**
 * Default implementaion of DataService
 * @author Diego Pacheco
 *
 */
public class DateServiceImpl implements DateService{
	@Override
	public String currentDate() {
		return new java.util.Date().toString();
	}
}
