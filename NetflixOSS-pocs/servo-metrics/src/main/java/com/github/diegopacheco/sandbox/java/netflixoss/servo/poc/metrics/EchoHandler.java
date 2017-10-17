package com.github.diegopacheco.sandbox.java.netflixoss.servo.poc.metrics;

import java.io.IOException;

import com.google.common.io.ByteStreams;
import com.sun.net.httpserver.HttpExchange;

public class EchoHandler extends BaseHandler {

    public EchoHandler() {
        init();
    }

    protected void handleImpl(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200, 0);
        ByteStreams.copy(exchange.getRequestBody(), exchange.getResponseBody());
        exchange.close();
    }
}