package com.github.diegopacheco.sandbox.java.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.File;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class Main {
	
	public static void main(String[] args) throws Throwable {
		
		Scheduler scheduler = new StdSchedulerFactory(new File(".").getAbsolutePath() + "/src/main/resources/" + "quartz_priority.properties").getScheduler();
		scheduler.start();
		
		scheduleJob(scheduler,new ErrorJob(),"group1");
		scheduleJob(scheduler,new OKJob(),"group1");
		scheduleJob(scheduler,new SlowJob(),"group1");
		scheduleJob(scheduler,new CPUDevourerJob(),"groupEvil2");
		
		while(true) {
			for(JobExecutionContext jec : scheduler.getCurrentlyExecutingJobs()) {
				System.out.println("Job for: " + jec.getJobDetail().getJobClass().getSimpleName());
				System.out.println("Running for: " + jec.getJobRunTime());
			}
			Thread.sleep(1000L);
		}
		
	}
	
	private static void scheduleJob(Scheduler scheduler,Job myJob,String group) {
	  JobDetail job = newJob(myJob.getClass())
	      .withIdentity("job_" + myJob.getClass().getSimpleName(), group)
	      .build();

	  Trigger trigger = newTrigger()
	      .withIdentity("trigger_" + myJob.getClass().getSimpleName(), group)
	      .startNow()
	      .withSchedule(
	      				 simpleSchedule()
	              .withIntervalInSeconds(5)
	              .withRepeatCount(5) 
	      ).build();

	  try {
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}
	
}
