package com.github.diegopacheco.quartz.scheduller;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyTask2 implements Job {
		
	public MyTask2() {}
	
  public void execute(JobExecutionContext context) throws JobExecutionException {
    System.err.println("2 - Hello World!  MyJob is executing. "  + DateTimeUtils.getCurrentTimeStamp());
    try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
  }
	
}