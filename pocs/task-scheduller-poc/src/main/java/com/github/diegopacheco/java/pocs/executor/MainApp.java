package com.github.diegopacheco.java.pocs.executor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainApp {

	public static void main(String[] args) throws Throwable{

		QueueManager.getInstance().register("g1");
		QueueManager.getInstance().register("g2");
		QueueManager.getInstance().register("g3");
		
		WorkerManager.getInstance().schedule(new GenericTaskAdapter("g1"));
		WorkerManager.getInstance().schedule(new GenericTaskAdapter("g2"));
		WorkerManager.getInstance().schedule(new GenericTaskAdapter("g3"));
	  
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
	  	public void execute() {
	  		System.out.println("3s Current Date:" + new Date());
	  	}
	  }, "g3", 3, TimeUnit.SECONDS);
	  
	}
}
