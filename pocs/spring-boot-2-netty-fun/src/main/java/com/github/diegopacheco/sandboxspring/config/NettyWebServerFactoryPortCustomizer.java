package com.github.diegopacheco.sandboxspring.config;

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import reactor.netty.http.server.HttpServer;

public class NettyWebServerFactoryPortCustomizer implements WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {

    @Override
    public void customize(NettyReactiveWebServerFactory serverFactory) {
        serverFactory.addServerCustomizers(new PortCustomizer(8443));
    }

    private static class PortCustomizer implements NettyServerCustomizer {

        private final int port;

        private PortCustomizer(int port) {
            this.port = port;
        }

        @Override
        public HttpServer apply(HttpServer httpServer) {
            return httpServer.port(port);
        }
    }
}
