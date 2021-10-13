package com.github.diegopacheco.sandboxspring.config;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/*
* Necessary to make H2 work with WebFlux(Netty) by default not being exposed on /h2-console/
* */
@Component
public class H2Console {

    private Server webServer;

    @Value("${h2console.h2-console-port}")
    Integer h2ConsolePort;

    @EventListener(ContextRefreshedEvent.class)
    public void start() throws java.sql.SQLException {
        System.out.println("starting h2 console at port "+h2ConsolePort);
        this.webServer = org.h2.tools.Server.createWebServer("-webPort", h2ConsolePort.toString(), "-tcpAllowOthers").start();
    }

    @EventListener(ContextClosedEvent.class)
    public void stop() {
        System.out.println("stopping h2 console at port "+h2ConsolePort);
        this.webServer.stop();
    }

}
