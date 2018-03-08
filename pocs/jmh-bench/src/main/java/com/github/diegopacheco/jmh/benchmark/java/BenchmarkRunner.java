package com.github.diegopacheco.jmh.benchmark.java;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	public void sum() {
		 int a = 2;
		 int b = 3;
		 int result = a + b;
		 assert(result==5);
	}
	
  public static void main(String[] args) throws Exception {
    Options opt = new OptionsBuilder()
        .include(".*" + BenchmarkRunner.class.getSimpleName() + ".*")
        .forks(1)
        .build();
    new Runner(opt).run();
  }
  
}