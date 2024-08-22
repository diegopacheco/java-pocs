package com.github.diegopacheco.sandboxspring.metrics;

import io.micrometer.core.instrument.ImmutableTag;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;
import java.util.List;

@Component
public class IOSchedulerMetrics implements MeterBinder {

    @Override
    public void bindTo(MeterRegistry registry) {
        Scheduler boundedElasticScheduler = Schedulers.boundedElastic();
        Schedulers.enableMetrics();
        /*
        ImmutableTag tag = new ImmutableTag("reactor", "boundedElastic");
        registry.gauge("reactor.boundedElastic.size", List.of(tag), boundedElasticScheduler);
        registry.gauge("reactor.boundedElastic.queueSize", boundedElasticScheduler, Scheduler::queueSize);
        registry.gauge("reactor.boundedElastic.ttlSeconds", boundedElasticScheduler, Scheduler::ttlSeconds);*/
    }
}