package com.github.diegopacheco.sandboxspring.config;

import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.incubator.channel.uring.IOUringEventLoopGroup;
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import org.springframework.context.annotation.Configuration;
import reactor.netty.http.server.HttpServer;

@Configuration
public class NettyServerCustomizerImpl implements NettyServerCustomizer {

    /**
     * check so max con -> sysctl net.core.somaxconn
     * sudo sysctl -w net.core.somaxconn=4096
     * sudo sh -c 'echo "net.core.somaxconn=4096" >> /etc/sysctl.conf'
     *
     * sysctl net.ipv4.tcp_rmem
     * sysctl net.ipv4.tcp_wmem
     * sysctl net.ipv4.tcp_congestion_control
     */
    @Override
    public HttpServer apply(HttpServer httpServer) {
        IOUringEventLoopGroup loopResources = new IOUringEventLoopGroup(48);
        return httpServer
                .runOn(loopResources)
                .tcpConfiguration(tcpServer -> tcpServer
                        .option(ChannelOption.SO_BACKLOG, 4096)
                        //.option(ChannelOption.SO_REUSEADDR, true)
                        .option(ChannelOption.TCP_FASTOPEN, 1024)
                        .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                        .childOption(ChannelOption.SO_KEEPALIVE, true)
                        .childOption(ChannelOption.TCP_NODELAY, true)
                        .childOption(ChannelOption.SO_RCVBUF, 1 * 1024 * 1024)  // 1 MB receive buffer
                        .childOption(ChannelOption.SO_SNDBUF, 1 * 1024 * 1024)  // 1 MB send buffer
                );
    }
}
