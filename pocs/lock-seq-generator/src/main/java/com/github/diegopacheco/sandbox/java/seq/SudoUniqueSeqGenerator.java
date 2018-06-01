package com.github.diegopacheco.sandbox.java.seq;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class generate sudo unique SLOTS numbers.
 * 
 * @author diegopacheco
 *
 */
public class SudoUniqueSeqGenerator {
	
	private static SudoUniqueSeqGenerator instance = null;
	private static final ReentrantLock lock = new ReentrantLock();
	private static final Map<String,ClusterTracker> map = new ConcurrentHashMap<>();
	
	private SudoUniqueSeqGenerator(){}
	
	public static synchronized SudoUniqueSeqGenerator getInstance() {
		if (instance==null) {
			instance = new SudoUniqueSeqGenerator();
		}
		return instance;
	}

	public void registerCluster(String id, Integer totalSize) {
		map.put(id, new ClusterTracker(id,totalSize));
	}
	
	public int nextSlot(String key) {
		lock.lock();
		try {
			
			ClusterTracker ct =  map.get(key);
			if (ct==null) {
				throw new RuntimeException("This cluster: " + key + " is not register - please register first! ");
			}
			
			AtomicInteger counter = ct.getCounter();
			if (counter.get() >= ct.getOriginalClusterSize()) {
				counter.set(ct.getOriginalClusterSize());
				throw new IllegalStateException("You reach the maximuling number of SLOTS for the cluster: " + ct.getId() + " which is: " + ct.getOriginalClusterSize());
			}
			
			int next = counter.incrementAndGet();
			return next;			
		}catch(Exception e) {
			if (!(e instanceof IllegalStateException))
				throw new RuntimeException("Could not generate next slot sequence.");
			throw new RuntimeException(e);
		}
		finally {
			lock.unlock();
		}
	}
	
}
