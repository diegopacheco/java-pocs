package com.github.diegopacheco.sandboxspring.config;

import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelOption;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import reactor.netty.http.server.HttpServer;
import reactor.netty.resources.LoopResources;
import java.util.concurrent.ThreadFactory;

@Configuration
public class WebFluxConfig {

    @Bean
    public TaskExecutor virtualThreadTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(0);
        executor.setMaxPoolSize(Integer.MAX_VALUE);
        executor.setQueueCapacity(0);
        ThreadFactory threadFactory = Thread.ofVirtual().factory();
        executor.setThreadFactory(threadFactory);
        executor.initialize();
        return executor;
    }

    @Bean
    public HttpServer httpServer(TaskExecutor virtualThreadTaskExecutor) {
        LoopResources loopResources = LoopResources.create("virtual-threads", 8192, true);
        return HttpServer.create()
                .runOn(loopResources)
                .option(ChannelOption.SO_BACKLOG, 8192)
                .option(ChannelOption.TCP_FASTOPEN, 8192)
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_RCVBUF, 1 * 1024 * 1024)  // 1 MB receive buffer
                .childOption(ChannelOption.SO_SNDBUF, 1 * 1024 * 1024); // 1 MB send buffer
    }
}