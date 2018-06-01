package com.github.diegopacheco.sandbox.java.seq;

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
	private static final AtomicInteger counter = new AtomicInteger(-1);
	
	private SudoUniqueSeqGenerator(){}
	
	public static synchronized SudoUniqueSeqGenerator getInstance() {
		if (instance==null) {
			instance = new SudoUniqueSeqGenerator();
		}
		return instance;
	}
	
	public int nextSlot() {
		lock.lock();
		try {
			int next = counter.incrementAndGet();
			return next;			
		}catch(Exception e) {
			throw new RuntimeException("Could not generate next slot sequence.");
		}
		finally {
			lock.unlock();
		}
	}
	
}
