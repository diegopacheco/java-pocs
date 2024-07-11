package com.github.diegopacheco.sandboxspring.config;

import io.netty.channel.ChannelPromise;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import org.slf4j.MDC;

//@Configuration
public class NettyServerCustomizerConfiguration implements WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(NettyServerCustomizerConfiguration.class);

    @Override
    public void customize(NettyReactiveWebServerFactory factory) {
        factory.addServerCustomizers(server -> server.tcpConfiguration(tcpServer -> tcpServer.doOnConnection(connection -> {
            ChannelPipeline pipeline = connection.channel().pipeline();
            pipeline.addLast(new XForwardedForLoggingHandler());
        })));
    }

    static class XForwardedForLoggingHandler extends ChannelDuplexHandler {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            logger.info("XForwardedForLoggingHandler called - msg: {}", ctx.getClass());
            if (msg instanceof HttpRequest) {
                HttpRequest request = (HttpRequest) msg;
                HttpHeaders headers = request.headers();
                String xForwardedFor = headers.get("X-FORWARDED-FOR");
                logger.info("XForwardedForLoggingHandler called - X-FORWARDED-FOR: {}", xForwardedFor);
                if (xForwardedFor != null) {
                    logger.info("adding X-FORWARDED-FOR to MDC: {}", xForwardedFor.trim());
                    MDC.put("X-FORWARDED-FOR", xForwardedFor);
                }
            }
            super.channelRead(ctx, msg);
        }

        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            if (msg instanceof HttpResponse) {
                // If you need to log something specific when the response is sent, do it here
            }
            super.write(ctx, msg, promise);
        }
    }
}