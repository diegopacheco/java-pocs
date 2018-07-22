package com.github.diegopacheco.java.pocs.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class DateTask implements Job {
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Current Date:" + new Date());
		QuietThread.sleep(1000);
	}
	
}
