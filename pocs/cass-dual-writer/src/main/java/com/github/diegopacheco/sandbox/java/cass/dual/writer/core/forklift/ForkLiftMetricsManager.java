package com.github.diegopacheco.sandbox.java.cass.dual.writer.core.forklift;

import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ForkLiftMetricsManager {
	
	private static ForkLiftMetricsManager instance;
	
	private ForkLiftExecutionMetric currentExecution = null;
	private Queue<ForkLiftExecutionMetric> previousExecutions = new ConcurrentLinkedQueue<>();
	
	private ForkLiftMetricsManager() {}
	
	public synchronized static ForkLiftMetricsManager getIntansce() {
		if (instance==null) {
			instance = new ForkLiftMetricsManager();
		}
		return instance;
	}
	
	public void addExecution(ForkLiftExecutionMetric current) {
		if (this.currentExecution!=null) {
			previousExecutions.add(this.currentExecution);
		}
		this.currentExecution = current;
	}

	public ForkLiftExecutionMetric getCurrentExecution() {
		return currentExecution;
	}

	public Queue<ForkLiftExecutionMetric> getPreviousExecutions() {
		return (Queue<ForkLiftExecutionMetric>) Collections.unmodifiableCollection(previousExecutions);
	}
	
}
