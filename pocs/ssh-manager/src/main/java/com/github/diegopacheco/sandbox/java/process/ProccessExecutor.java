package com.github.diegopacheco.sandbox.java.process;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ProcessEcecutor Enqueue ProcessRequests and run them in SERIAL way also providing Futures and Proper PIDMetadata for each process.
 * 
 * @author diegopacheco
 * @version 1.0
 *
 */
public class ProccessExecutor {
	
	private static ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);
	private static Queue<ProcessRequest> processQueue = new ConcurrentLinkedQueue<>();
	private static ProccessExecutor instance;
	
	private ProccessExecutor(){}
	
	public static synchronized ProccessExecutor getInstance() {
		if (instance==null) {
			instance = new ProccessExecutor();
		  threadPool.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
            try {
                ProcessRequest pr = processQueue.poll();
                System.out.println("Doing: " + pr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		  }, 0, 15, TimeUnit.SECONDS);
		}
		return instance;
	}
	
	public Future<PIDMetadata> execute(ProcessRequest pr) {
		processQueue.add(pr);	
		return null;
	}
	
	public static void main(String[] args) {
		ProccessExecutor pe = ProccessExecutor.getInstance();
		pe.execute(new ProcessRequest("list 1","ls -lsa", null));
		pe.execute(new ProcessRequest("list 2","ls -lsa", null));
		pe.execute(new ProcessRequest("list 3","ls -lsa", null));
	}
	
}	
