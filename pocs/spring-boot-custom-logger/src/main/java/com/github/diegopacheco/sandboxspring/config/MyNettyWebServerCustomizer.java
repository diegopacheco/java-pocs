package com.github.diegopacheco.sandboxspring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;
import reactor.netty.http.server.logging.AccessLog;

@Component
public class MyNettyWebServerCustomizer
        implements WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {

    @Value("${access.log.format}")
    private String accessLogFormat;

    @Override
    public void customize(NettyReactiveWebServerFactory factory) {
        factory.addServerCustomizers(httpServer ->
                httpServer.accessLog(true, x ->
                        AccessLog.create(
                                accessLogFormat,
                                x.method(), x.uri(), x.requestHeader("MYHEADER"),
                                x.requestHeader("X-FORWARDED-FOR"))
                ));
    }
}