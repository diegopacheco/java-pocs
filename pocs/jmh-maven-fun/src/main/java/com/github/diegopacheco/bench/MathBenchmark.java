package com.github.diegopacheco.bench;

import com.github.diegopacheco.service.MathService;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class MathBenchmark {

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1,batchSize = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void init() {
        MathService ms = new MathService();
        ms.sum(1D,1D);
        ms.sub(1D,1D);
        ms.mul(1D,1D);
        ms.div(1D,1D);
    }

}
