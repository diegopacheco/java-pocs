package com.github.diegopacheco.sandboxspring.config;

import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.incubator.channel.uring.IOUringEventLoopGroup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.netty.http.server.HttpServer;
import reactor.netty.resources.LoopResources;

//@Configuration
public class NettyConfig {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    @Bean
    public HttpServer httpServer() {

        //LoopResources loopResources = LoopResources.create("http", 48, true);

        IOUringEventLoopGroup loopResources = new IOUringEventLoopGroup(48);

        //EpollEventLoopGroup loopResources = new EpollEventLoopGroup(48);

        //NioEventLoopGroup loopResources = new NioEventLoopGroup(48);

        return HttpServer.create()
                .runOn(loopResources)
                .option(ChannelOption.SO_BACKLOG, 4096)
                .option(ChannelOption.TCP_FASTOPEN, 1024)
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_RCVBUF, 1 * 1024 * 1024)  // 1 MB receive buffer
                .childOption(ChannelOption.SO_SNDBUF, 1 * 1024 * 1024); // 1 MB send buffer
        //return null;
    }

}
