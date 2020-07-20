package com.github.diegopacheco.javapocs.reactornetty.http;

public class HttpServer {
    public static void main(String[] args) throws Exception{
        System.out.println("Running HTTP Server on http://localhost:8080/...");
        reactor.netty.http.server.HttpServer server = reactor.netty.http.server.HttpServer.create()
                .port(8080)
                .route(routes ->
                        routes.post("/test/{param}", (request, response) ->
                                response.sendString(request.receive()
                                        .asString()
                                        .map(s -> s + ' ' + request.param("param") + '!')
                                        .log("http-server"))));
        server.bindNow().onDispose().block();
    }
}
