package com.github.diegopacheco.sandbox.java.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class Main {
	
	public static void main(String[] args) throws Throwable {
		
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		
		scheduleJob(scheduler,new ErrorJob());
		scheduleJob(scheduler,new OKJob());
		scheduleJob(scheduler,new SlowJob());
		
		while(true) {
			for(JobExecutionContext jec : scheduler.getCurrentlyExecutingJobs()) {
				System.out.println("Job for: " + jec.getJobDetail().getJobClass().getSimpleName());
				System.out.println("Running for: " + jec.getJobRunTime());
			}
			Thread.sleep(1000L);
		}
		
	}
	
	private static void scheduleJob(Scheduler scheduler,Job myJob) {
	  JobDetail job = newJob(myJob.getClass())
	      .withIdentity("job_" + myJob.getClass().getSimpleName(), "group1")
	      .build();

	  Trigger trigger = newTrigger()
	      .withIdentity("trigger_" + myJob.getClass().getSimpleName(), "group1")
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
