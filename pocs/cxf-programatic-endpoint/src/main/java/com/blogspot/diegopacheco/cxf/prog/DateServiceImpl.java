package com.blogspot.diegopacheco.cxf.prog;

import java.util.Date;

public class DateServiceImpl implements DateService{
	
	@Override
	public String checkCurrentDate() {
		return new Date().toString();
	}
}
