package com.github.diegopacheco.java.pocs.quartz;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.quartz.Job;

public class WorkerManager {
	
	private static WorkerManager instance;
	private ScheduledExecutorService executorRecurrent  = Executors.newScheduledThreadPool(1);
	
	public synchronized static WorkerManager getInstance() {
		if(instance==null) {
			instance=new WorkerManager();
		}
		return instance;
	}
	
	public void scheduleRecurrent(Job t,String group,long period, TimeUnit timeUnit){
		executorRecurrent.scheduleAtFixedRate(() ->  QueueManager.getInstance().enqueueTask(t, group) , 0, period, timeUnit);
	}
	
}