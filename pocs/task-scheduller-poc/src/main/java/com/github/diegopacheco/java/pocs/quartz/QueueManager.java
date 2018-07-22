package com.github.diegopacheco.java.pocs.quartz;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.quartz.Job;

public class QueueManager {
	
	private static QueueManager instance;
	private Map<String, Queue<Job>> groupQueueMappings = new ConcurrentHashMap<>();
	
	public synchronized static QueueManager getInstance(){
		if (instance==null) {
			instance = new QueueManager();
		}
		return instance;
	}
	
	public void register(String group) {
		groupQueueMappings.put(group, new ConcurrentLinkedQueue<>());
	}
	
	public void enqueueTask(Job task,String group){
		Queue<Job> queue = groupQueueMappings.get(group);
		validateGrpup(group);
		queue.add(task);
	}
	
	public Job giveMeWork(String group) {
		Queue<Job> queue = groupQueueMappings.get(group);
		validateGrpup(group);
		return queue.poll();
	}
	
	private void validateGrpup(String group){
		Queue<Job> queue = groupQueueMappings.get(group);
		if (queue==null) {
			throw new RuntimeException("This group: " + group + " Is not registered! " );
		}
	}
	
}
