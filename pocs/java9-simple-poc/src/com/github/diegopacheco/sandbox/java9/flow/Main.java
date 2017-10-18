package com.github.diegopacheco.sandbox.java9.flow;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		
		FlowRange source = new FlowRange(1, 5, Runnable::run);
        TestFlowSubscriber<Integer> ts = new TestFlowSubscriber<>();
        source.subscribe(ts);
 
        assert(Arrays.asList(1, 2, 3, 4, 5).equals(ts.values()));
        assert(1 == ts.completions());
        assert(ts.errors().isEmpty());
        System.out.println("All Good!");
        
        FlowRange source2 = new FlowRange(1, 5, ForkJoinPool.commonPool());
        TestFlowSubscriber<Integer> ts2 = new TestFlowSubscriber<>();
     
        source2.subscribe(ts2);
     
        try {
			assert(ts2.await(5, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        assert(Arrays.asList(1, 2, 3, 4, 5).equals(ts2.values()));
        assert(1 == ts2.completions());
        assert(ts2.errors().isEmpty());
        System.out.println("All Good Async!");
        
	}
}
