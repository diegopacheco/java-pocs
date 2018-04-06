package com.github.diegopacheco.sandbox.java.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Job1 implements Job {

	public Job1() {}

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.err.println("1 - Hello World!  MyJob is executing. " + new Date() +  " - " + context.getTrigger().getPriority() + " - " + context.getJobDetail().getKey().getName());
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}