package com.github.diegopacheco.sandbox.java.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.File;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Main {
	
	public static void main(String[] args) throws Throwable {
		
		Scheduler schedulerFast = new StdSchedulerFactory(new File(".").getAbsolutePath() + "/src/main/resources/" + "quartz_priority_fast.properties").getScheduler();
		schedulerFast.start();
		
		Scheduler schedulerSlow = new StdSchedulerFactory(new File(".").getAbsolutePath() + "/src/main/resources/" + "quartz_priority_slow.properties").getScheduler();
		schedulerSlow.start();
		
		schedulerFast.getListenerManager().addJobListener(new JobListener() {
			@Override
			public String getName() {
				return "Sauron";
			}
			@Override
			public void jobToBeExecuted(JobExecutionContext context) {
			}
			@Override
			public void jobExecutionVetoed(JobExecutionContext context) {
			}
			@Override
			public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
				  System.out.println("*** JOB FINISHED: " + context.getJobInstance().getClass().getSimpleName());
			}
		});
		
		schedulerSlow.getListenerManager().addJobListener(new JobListener() {
			@Override
			public String getName() {
				return "SauronMan";
			}
			@Override
			public void jobToBeExecuted(JobExecutionContext context) {
			}
			@Override
			public void jobExecutionVetoed(JobExecutionContext context) {
			}
			@Override
			public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
				  System.out.println("*** JOB FINISHED: " + context.getJobInstance().getClass().getSimpleName());
			}
		});
		
		scheduleJob(schedulerSlow,new ErrorJob(),"group1",5);
		scheduleJob(schedulerSlow,new SlowJob(),"group1",5);
		scheduleJob(schedulerFast,new OKJob(),"group2",-1);
		scheduleJob(schedulerSlow,new SleepJob(),"group3Sleep",-1);
		scheduleJob(schedulerSlow,new CPUDevourerJob(),"groupEvil2",-1);
		
		while(true) {

			for(JobExecutionContext jec : schedulerFast.getCurrentlyExecutingJobs()) {
				System.out.println("Job   : " + jec.getJobDetail().getJobClass().getSimpleName());
				System.out.println("Fired in: " + jec.getTrigger().getFinalFireTime());
			}
			
			for(JobExecutionContext jec : schedulerSlow.getCurrentlyExecutingJobs()) {
				System.out.println("Job   : " + jec.getJobDetail().getJobClass().getSimpleName());
				System.out.println("Fired in: " + jec.getTrigger().getFinalFireTime());
			}
			
			Thread.sleep(1000L);
		}
		
	}
	
	private static void scheduleJob(Scheduler scheduler,Job myJob,String group,Integer counter) {
		
	  JobDetail job = newJob(myJob.getClass())
	      .withIdentity("job_" + myJob.getClass().getSimpleName(), group)
	      .build();

	  TriggerBuilder<Trigger> builder = newTrigger()
	      .withIdentity("trigger_" + myJob.getClass().getSimpleName(), group);
	      
	  TriggerBuilder<SimpleTrigger> builder2;
	  	if ( counter!=-1 ) {
		  		builder2 = builder.withSchedule(
	   				 simpleSchedule()
	           .withIntervalInSeconds(5)
	           .withRepeatCount(5) 
		  	  );
	  	}else {
	  		builder2 = builder.withSchedule(
	   				 simpleSchedule()
	           .withIntervalInSeconds(5)
	           .repeatForever()
		  	  );
	  	}
	      
	  Trigger trigger = builder2.startNow().build(); 
	  
	  try {
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	  
	}
	
}
