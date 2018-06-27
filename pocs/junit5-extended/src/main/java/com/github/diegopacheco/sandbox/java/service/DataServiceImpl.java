package com.github.diegopacheco.sandbox.java.service;

import java.util.Date;

public class DataServiceImpl implements DataService {

	@Override
	public String getCurrentDate(Version version) {
		
		if (version==null || "".equals(version.getId()))
			throw new IllegalArgumentException("Version cannot be null or empty.");
		
		switch (version.getId()) {
		case "1.x":
			return new Date().toString(); 
		case "2.x":
			return new Date().toString(); 
		default:
			throw new RuntimeException("Version: " + version.getId() + " not supported! ");
		}
		
	}
	
}
