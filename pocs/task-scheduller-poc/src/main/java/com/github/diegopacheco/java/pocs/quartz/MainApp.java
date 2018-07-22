package com.github.diegopacheco.java.pocs.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class MainApp {

	public static void main(String[] args) throws Throwable{

		QueueManager.getInstance().register("g1");
		QueueManager.getInstance().register("g2");
		
	  Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
	  scheduler.start();
		
	  JobDetail job1 = newJob(Group1TaskAdapter.class)
	      .withIdentity("job1", "group1")
	      .build();
	  
	  Trigger trigger1 = newTrigger()
	      .withIdentity("trigger1", "group1")
	      .startNow()
	      .withSchedule(simpleSchedule()
	              .withIntervalInSeconds(1)
	              .repeatForever())
	      .build();
	  
	  JobDetail job2 = newJob(Group2TaskAdapter.class)
	      .withIdentity("job2", "group2")
	      .build();
	  
	  Trigger trigger2 = newTrigger()
	      .withIdentity("trigger2", "group2")
	      .startNow()
	      .withSchedule(simpleSchedule()
	              .withIntervalInSeconds(1)
	              .repeatForever())
	      .build();

	  scheduler.scheduleJob(job1, trigger1);
	  scheduler.scheduleJob(job2, trigger2);
	  
	  QuietThread.sleep(3000);
	  QueueManager.getInstance().enqueueTask(new DateTask(), "g1");
	  QueueManager.getInstance().enqueueTask(new DateTask(), "g1");
	  QueueManager.getInstance().enqueueTask(new DateTask(), "g1");
	  QueueManager.getInstance().enqueueTask(new DateTask(), "g1");
	  QueueManager.getInstance().enqueueTask(new DateTask(), "g1");
	  QuietThread.sleep(5000);
	  QueueManager.getInstance().enqueueTask(new DateTask(), "g1");
	  QueueManager.getInstance().enqueueTask(new DateTask(), "g2");
	  QueueManager.getInstance().enqueueTask(new DateTask(), "g1");
	  QueueManager.getInstance().enqueueTask(new DateTask(), "g2");
	  
	}
}
