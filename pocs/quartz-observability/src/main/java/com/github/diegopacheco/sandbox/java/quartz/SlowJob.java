package com.github.diegopacheco.sandbox.java.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SlowJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			Thread.sleep(4000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("OK I'm done - took me 4s");
	}

}
