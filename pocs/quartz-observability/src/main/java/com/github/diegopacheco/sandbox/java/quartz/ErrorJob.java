package com.github.diegopacheco.sandbox.java.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ErrorJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		throw new RuntimeException("Error by Design");
	}

}
