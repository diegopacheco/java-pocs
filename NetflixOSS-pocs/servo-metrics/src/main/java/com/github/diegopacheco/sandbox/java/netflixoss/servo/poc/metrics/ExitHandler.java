package com.github.diegopacheco.sandbox.java.netflixoss.servo.poc.metrics;

import java.io.Closeable;
import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;

public class ExitHandler extends BaseHandler {

    private final Closeable server;

    public ExitHandler(Closeable server) {
        this.server = server;
        init();
    }

    protected void handleImpl(HttpExchange exchange) throws IOException {
        try {
            exchange.sendResponseHeaders(200, 0);
            exchange.close();
        } finally {
            server.close();
        }
    }
}