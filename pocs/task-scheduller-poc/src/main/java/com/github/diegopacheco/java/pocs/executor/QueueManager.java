package com.github.diegopacheco.java.pocs.executor;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueManager {
	
	private static QueueManager instance;
	private Map<String, Queue<Task>> groupQueueMappings = new ConcurrentHashMap<>();
	private Map<String, Boolean>     freeQueueMappings = new ConcurrentHashMap<>();
	
	public synchronized static QueueManager getInstance(){
		if (instance==null) {
			instance = new QueueManager();
		}
		return instance;
	}
	
	public void register(String group) {
		groupQueueMappings.put(group, new ConcurrentLinkedQueue<>());
		freeQueueMappings.put(group, true);
	}
	
	public void enqueueTask(Task task,String group){
		Queue<Task> queue = groupQueueMappings.get(group);
		validateGrpup(group);
		queue.add(task);
	}
	
	public Task giveMeWork(String group) {
		validateGrpup(group);
		Queue<Task> queue = groupQueueMappings.get(group);
		if (queue.size()==0) 
			return null;

		if(freeQueueMappings.get(group)) {
			freeQueueMappings.put(group, false);
			return queue.poll();
		}else {
			System.out.println("Queue: " + group + " is busy now... " + " Size: " + queue.size());
			return null;
		}
	}
	
	public void releaseWork(String group){
		validateGrpup(group);
		freeQueueMappings.put(group, true);
	}
	
	private void validateGrpup(String group){
		Queue<Task> queue = groupQueueMappings.get(group);
		if (queue==null) {
			throw new RuntimeException("This group: " + group + " Is not registered! " );
		}
	}
	
}
