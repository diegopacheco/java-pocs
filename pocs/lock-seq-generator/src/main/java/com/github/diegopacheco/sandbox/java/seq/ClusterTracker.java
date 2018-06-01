package com.github.diegopacheco.sandbox.java.seq;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ClusterTracker {
	
	private String id;
	private int originalClusterSize = 3;
	private Queue<Integer> slotsInUse = new ConcurrentLinkedQueue<>();
	private AtomicInteger counter = new AtomicInteger(-1);
	
	public ClusterTracker(String id, int originalClusterSize) {
		super();
		this.id = id;
		this.originalClusterSize = originalClusterSize;
	}
	public ClusterTracker(String id, int originalClusterSize, AtomicInteger counter) {
		super();
		this.id = id;
		this.originalClusterSize = originalClusterSize;
		this.counter = counter;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public int getOriginalClusterSize() {
		return originalClusterSize;
	}
	public void setOriginalClusterSize(int originalClusterSize) {
		this.originalClusterSize = originalClusterSize;
	}

	public AtomicInteger getCounter() {
		return counter;
	}
	public void setCounter(AtomicInteger counter) {
		this.counter = counter;
	}

	public Queue<Integer> getSlotsInUse() {
		return slotsInUse;
	}
	public void setSlotsInUse(Queue<Integer> slotsInUse) {
		this.slotsInUse = slotsInUse;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClusterTracker other = (ClusterTracker) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ClusterTracker [id=" + id + ", originalClusterSize=" + originalClusterSize + ", slotsInUse=" + slotsInUse
		    + ", counter=" + counter + "]";
	}
	
}
