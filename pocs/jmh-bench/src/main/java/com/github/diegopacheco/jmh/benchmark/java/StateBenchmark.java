package com.github.diegopacheco.jmh.benchmark.java;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

public class StateBenchmark {
	
	 @State(Scope.Thread)
   public static class BenchmarkState {
       double x = Math.PI;
   }
	 
	 @Benchmark
   public void measureShared(BenchmarkState state) {
       state.x++;
   }
	 
}
