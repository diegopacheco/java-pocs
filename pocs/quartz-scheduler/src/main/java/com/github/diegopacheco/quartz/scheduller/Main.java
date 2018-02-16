package com.github.diegopacheco.quartz.scheduller;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class Main {
	public static void main(String[] args) throws Throwable {
		
	  Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
	  System.out.println("Scheduller: " + scheduler.getSchedulerName());
	  scheduler.start();
		
	  JobDetail job1 = newJob(MyTask1.class)
	      .withIdentity("job1", "group1")
	      .build();
	  
	  JobDetail job2 = newJob(MyTask2.class)
	      .withIdentity("job2", "group1")
	      .build();
	  
	  Trigger trigger1 = newTrigger()
	      .withIdentity("trigger1", "group1")
	      .startNow()
	      .withSchedule(simpleSchedule()
	              .withIntervalInSeconds(5)
	              .repeatForever())
	      .build();
	  
	  Trigger trigger2 = newTrigger()
	      .withIdentity("trigger2", "group1")
	      .startNow()
	      .withSchedule(simpleSchedule()
	              .withIntervalInSeconds(5)
	              .repeatForever())
	      .build();

	  scheduler.scheduleJob(job1, trigger1);
	  scheduler.scheduleJob(job2, trigger2);
	      
		
	}
}
