package com.github.diegopacheco.java.pocs.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class MainApp {

	public static void main(String[] args) throws Throwable{

		QueueManager.getInstance().register("g1");
		QueueManager.getInstance().register("g2");
		QueueManager.getInstance().register("g3");
		
	  Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
	  scheduler.start();
		
	  JobDetail job1 = newJob(GenericTaskAdapter.class)
	      .withIdentity("job1", "g1")
	      .build();
	  
	  Trigger trigger1 = newTrigger()
	      .withIdentity("trigger1", "g1")
	      .startNow()
	      .withSchedule(simpleSchedule()
	              .withIntervalInSeconds(1)
	              .repeatForever())
	      .build();
	  
	  JobDetail job2 = newJob(GenericTaskAdapter.class)
	      .withIdentity("job2", "g2")
	      .build();
	  
	  Trigger trigger2 = newTrigger()
	      .withIdentity("trigger2", "g2")
	      .startNow()
	      .withSchedule(simpleSchedule()
	              .withIntervalInSeconds(1)
	              .repeatForever())
	      .build();
	  
	  JobDetail job3 = newJob(GenericTaskAdapter.class)
	      .withIdentity("job3", "g3")
	      .build();
	  
	  Trigger trigger3 = newTrigger()
	      .withIdentity("trigger3", "g3")
	      .startNow()
	      .withSchedule(simpleSchedule()
	              .withIntervalInSeconds(1)
	              .repeatForever())
	      .build();

	  scheduler.scheduleJob(job1, trigger1);
	  scheduler.scheduleJob(job2, trigger2);
	  scheduler.scheduleJob(job3, trigger3);
	  
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
	  
	  //Recurrent schedulling
	  WorkerManager.getInstance().scheduleRecurrent(new DateTask() {
	  	@Override
	  	public void execute(JobExecutionContext context) throws JobExecutionException {
	  		System.out.println("3s Current Date:" + new Date());
	  	}
	  }, "g3", 3, TimeUnit.SECONDS);
	  
	}
}
