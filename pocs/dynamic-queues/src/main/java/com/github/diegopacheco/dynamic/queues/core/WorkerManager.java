package com.github.diegopacheco.dynamic.queues.core;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class WorkerManager {
	
	private static WorkerManager instance;
	private static ScheduledExecutorService executor                = Executors.newScheduledThreadPool(10);
	private static ScheduledExecutorService executorRecurrent       = Executors.newScheduledThreadPool(1);
	private static ScheduledExecutorService executorRecurrentQueue  = Executors.newScheduledThreadPool(1);
	
	private static Map<String, GenericWorker> workerQueueMap = new ConcurrentHashMap<>();
	private static Queue<GenericWorker> workers = new ConcurrentLinkedQueue<>();
	
	public boolean registerWorker(String queue, String name) {
		workerQueueMap.put(queue, new GenericWorker(queue, name));
		return workers.add(workerQueueMap.get(queue));
	}
	
	public boolean unregisterWorker(String queue) {
		workers.remove(workerQueueMap.get(queue));
		return workerQueueMap.remove(queue) != null;
	}
	
	public synchronized static WorkerManager getInstance() {
		if(instance==null) {
			instance=new WorkerManager();
			registerExecutors();
		}
		return instance;
	}

	private static void registerExecutors() {
		executorRecurrent.scheduleAtFixedRate(() ->  { 
			
			System.out.println("======================== STATS   ======================================================");
			System.out.println("Executor  queue size: " + ((ThreadPoolExecutor)executor).getQueue().size());
			System.out.println("Recurrent queue size: " + ((ThreadPoolExecutor)executorRecurrent).getQueue().size());
			System.out.println("Queue     queue size: " + ((ThreadPoolExecutor)executorRecurrentQueue).getQueue().size());
			QueueManager.getInstance().getStats().forEach( (k,s)  -> System.out.println("Queue: " + k + " size: " + s) );
			WorkerManager.getInstance().getStats().forEach( (k,w) -> System.out.print(k + " ") );
			
			System.out.println("\n======================== Running   ====================================================");
			if (workers.size()==0) {
				System.out.println("WorkerSheduller [" + Thread.currentThread().getName()  +  "] No Workers Registerd ");
			}else {
				workers.stream().forEach( w -> executor.submit(w) );
			}
			
		}, 0, 1, TimeUnit.SECONDS);
	}
	
	public void scheduleRecurrent(Task t,String group,long period, TimeUnit timeUnit){
		executorRecurrentQueue.scheduleAtFixedRate(() ->  QueueManager.getInstance().enqueueTask(t, group) , 0, period, timeUnit);
	}
	
	public Map<String,String> getStats(){
		Map<String,String> stats = new ConcurrentHashMap<>();
		workerQueueMap.keySet().stream().forEach( k ->  stats.put(workerQueueMap.get(k).getName(), k) );
		return stats;
	}
	
}