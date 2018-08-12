package com.github.diegopacheco.dynamic.queues.core;

import java.util.concurrent.TimeUnit;

public class SchedullerManager {
	
	private static SchedullerManager instance;
	
	public synchronized static SchedullerManager getInstance(){
		if (instance==null) {
			instance = new SchedullerManager();
		}
		return instance;
	}
	
	public void register(String queue) {
		QueueManager.getInstance().register(queue);
		WorkerManager.getInstance().registerWorker(queue,"w" + queue);
	}
	
	public void unregister(String queue) {
		QueueManager.getInstance().unregister(queue);
		WorkerManager.getInstance().unregisterWorker(queue);
	}
	
	public void enqueueTask(String queue, Task t){
		QueueManager.getInstance().enqueueTask(t, queue);
	}
	
	public void scheduleRecurrent(Task t,String group,long period, TimeUnit timeUnit){
		WorkerManager.getInstance().scheduleRecurrent(t, group, period, timeUnit);
	}
	
}
