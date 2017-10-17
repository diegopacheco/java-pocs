package com.blogspot.diegopacheco.springframework25.jmx;

import java.util.Date;

public class DateServiceImpl implements DateService{
	public String getDate() {
		return new Date().toString();
	}
}
