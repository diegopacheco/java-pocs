package com.github.diegopacheco.sandbox.java.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class Main {
	
	public static void main(String[] args) throws Throwable {
		
		SchedulerFactory sf = new StdSchedulerFactory(new File(".").getAbsolutePath() + "/src/main/resources/" + "quartz_priority.properties");
		Scheduler sched = sf.getScheduler();
		
		Calendar calendar = Calendar.getInstance(); 
		calendar.add(Calendar.SECOND, 5);
		
		Date startTime = new Date();
		startTime.setTime(calendar.getTime().getTime());
		
	  JobDetail job1 = newJob(Job1.class)
	      .withIdentity("job1", "group1")
	      .build();
	  
	  JobDetail job2 = newJob(Job1.class)
	      .withIdentity("job2", "group1")
	      .build();
	  
	  JobDetail job3 = newJob(Job1.class)
	      .withIdentity("job3", "group1")
	      .build();
	  
	  JobDetail job4 = newJob(Job1.class)
	      .withIdentity("job4", "group1")
	      .build();	  

		Trigger trigger1 = newTrigger()
		    .withIdentity("P1")
		    .startAt(startTime)
		    .withSchedule(simpleSchedule().withRepeatCount(1).withIntervalInSeconds(5))
		    .withPriority(1)
		    .forJob(job1)
		    .build();

		Trigger trigger2 = newTrigger()
		    .withIdentity("P5")
		    .startAt(startTime)
		    .withSchedule(simpleSchedule().withRepeatCount(1).withIntervalInSeconds(5))
		    .withPriority(5)
		    .forJob(job2)
		    .build();

		Trigger trigger3 = newTrigger()
		    .withIdentity("P10")
		    .startAt(startTime)
		    .withSchedule(simpleSchedule().withRepeatCount(1).withIntervalInSeconds(5))
		    .withPriority(10)
		    .forJob(job3)
		    .build();
		
		Trigger trigger4 = newTrigger()
		    .withIdentity("P15")
		    .startAt(startTime)
		    .withSchedule(simpleSchedule().withIntervalInSeconds(0).withRepeatCount(0))
		    .withPriority(15)
		    .forJob(job4)
		    .build();
		
		sched.scheduleJob(job1,trigger1);
		sched.scheduleJob(job2,trigger2);
		sched.scheduleJob(job3,trigger3);
		sched.scheduleJob(job4,trigger4);
		sched.start();
		
	}
	
}
