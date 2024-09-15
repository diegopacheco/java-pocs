package com.github.diegopacheco.sandboxspring.config;

import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class VirtualThreadScheduler {

    public static Scheduler virtualThreadScheduler() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(
                Runtime.getRuntime().availableProcessors(),
                Thread.ofVirtual().factory()
        );
        return Schedulers.fromExecutorService(executorService);
    }
}