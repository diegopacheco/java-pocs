package com.github.diegopacheco.java.pocs.quartz;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.quartz.Job;

public class CircularQueueTracker {
	
	private static CircularQueueTracker instance;
	
	Map<String,Queue<Job>> queues = new ConcurrentHashMap<>(); 
	AtomicInteger insertIndex = new AtomicInteger(-1);
	AtomicInteger lastAccessPosition = new AtomicInteger(0);
	
	public static synchronized CircularQueueTracker getInstance() {
		if (instance==null) {
			instance = new CircularQueueTracker();
		}
		return instance;
	}
	
	public String register(Queue<Job> q) {
		String key = "q"+insertIndex.incrementAndGet();
		queues.put(key,q);
		return key;
	}
	
	public void unRegister(String key) {
		Queue<Job> q = queues.remove(key);
		if(q!=null)
			insertIndex.decrementAndGet();
	}
	
	public synchronized Queue<Job> next(){
		
		if (queues.size()==0)
			return null;
		Queue<Job> q = queues.get("q"+lastAccessPosition.get());
		
		if (lastAccessPosition.get()+1 > insertIndex.get()) {
			lastAccessPosition = new AtomicInteger(0);
		}else {
			lastAccessPosition.incrementAndGet();
		}
		return q;
	}
	
}
