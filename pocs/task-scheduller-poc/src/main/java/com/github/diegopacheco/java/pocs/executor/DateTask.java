package com.github.diegopacheco.java.pocs.executor;

import java.util.Date;

public class DateTask implements Task {
	
	@Override
	public void execute() {
		System.out.println("Current Date:" + new Date());
		//QuietThread.sleep(1000);
	}
	
}
