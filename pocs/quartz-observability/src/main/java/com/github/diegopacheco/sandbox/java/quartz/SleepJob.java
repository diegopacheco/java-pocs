package com.github.diegopacheco.sandbox.java.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SleepJob implements Job{
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			Thread.sleep(90000000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
