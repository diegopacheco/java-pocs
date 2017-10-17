package com.github.diegopacheco.sandbox.java.netty.time;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {
    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = Integer.parseInt("9090");
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        
        try {
            Bootstrap b = new Bootstrap(); 
            b.group(workerGroup); 
            b.channel(NioSocketChannel.class); 
            b.option(ChannelOption.SO_KEEPALIVE, true); 
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeClientHandler());
                }
            });
            
            ChannelFuture f = b.connect(host, port).sync(); 
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}