package com.github.diegopacheco.sandboxspring.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;
import reactor.netty.ReactorNetty;

@Component
public class ReactorNettyMetrics implements MeterBinder {

    @Override
    public void bindTo(MeterRegistry registry) {
        registry.gauge("reactor.netty.ioWorkerCount", Integer.parseInt(System.getProperty(ReactorNetty.IO_WORKER_COUNT, "4")));
        registry.gauge("reactor.netty.udp.ioThreadCount", Integer.parseInt(System.getProperty(ReactorNetty.UDP_IO_THREAD_COUNT, "4")));
        registry.gauge("reactor.netty.pool.maxConnections", Integer.parseInt(System.getProperty(ReactorNetty.POOL_MAX_CONNECTIONS, "16")));
    }
}