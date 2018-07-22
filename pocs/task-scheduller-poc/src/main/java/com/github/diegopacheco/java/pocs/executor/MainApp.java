package com.github.diegopacheco.java.pocs.executor;

public class MainApp {

	public static void main(String[] args) throws Throwable{

		QueueManager.getInstance().register("g1");
		QueueManager.getInstance().register("g2");
		
		WorkerManager.getInstance().schedule(new Group1TaskAdapter());
		WorkerManager.getInstance().schedule(new Group2TaskAdapter());
	  
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
