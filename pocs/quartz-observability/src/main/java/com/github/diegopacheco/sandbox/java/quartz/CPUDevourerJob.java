package com.github.diegopacheco.sandbox.java.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CPUDevourerJob implements Job{
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		 String x = "";
		 int i = 0;
		  while(true) {
		  	 x += " ";
		  	 if (i==1000) {
		  		 i = 0;
		  		 x = "";
		  		 if (x=="") x = "";
		  		 try {
						Thread.sleep(2000L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		  	 }
		  	 i++;
		  }
	}

}
