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
public class SlotManager {
	
	private static SlotManager instance = null;
	private static final ReentrantLock lock = new ReentrantLock();
	private static final Map<String,ClusterTracker> map = new ConcurrentHashMap<>();
	
	private SlotManager(){}
	
	public static synchronized SlotManager getInstance() {
		if (instance==null) {
			instance = new SlotManager();
		}
		return instance;
	}

	public void registerCluster(String id, Integer totalSize) {
		map.put(id, new ClusterTracker(id,totalSize));
	}
	
	public int nextSlot(String id) {
		lock.lock();
		try {
			
			ClusterTracker ct =  map.get(id);
			if (ct==null) {
				throw new RuntimeException("This cluster: " + id + " is not register - please register first! ");
			}
			
			AtomicInteger counter = ct.getCounter();
			if (counter.get() >= ct.getOriginalClusterSize()) {
				counter.set(ct.getOriginalClusterSize());
				throw new IllegalStateException("You reach the maximuling number of SLOTS for the cluster: " + ct.getId() + " which is: " + ct.getOriginalClusterSize());
			}
			
			int next = counter.incrementAndGet();
			ct.getSlotsInUse().add(next);
			
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
	
	public void returnSlot(String id,Integer slot) {
		lock.lock();
		try {
		
			ClusterTracker ct =  map.get(id);
			if (ct==null) {
				throw new RuntimeException("This cluster: " + id + " is not register - please register first! ");
			}
			
			ct.getSlotsInUse().remove(slot);
		}catch(Exception e) {
			if (!(e instanceof IllegalStateException))
				throw new RuntimeException("Could not return slot.");
			throw new RuntimeException(e);
		}
		finally {
			lock.unlock();
		}
	}
	
}
