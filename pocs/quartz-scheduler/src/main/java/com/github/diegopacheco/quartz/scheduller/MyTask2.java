package com.github.diegopacheco.quartz.scheduller;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyTask2 implements Job {
		
	public MyTask2() {}
	
  public void execute(JobExecutionContext context) throws JobExecutionException {
    System.err.println("2 - Hello World!  MyJob is executing. "  + new Date().toString());
  }
	
}