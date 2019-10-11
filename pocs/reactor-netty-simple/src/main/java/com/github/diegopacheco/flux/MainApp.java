package com.github.diegopacheco.flux;

import reactor.core.publisher.Flux;
import reactor.netty.ByteBufFlux;
import reactor.netty.http.client.HttpClient;
import reactor.netty.http.server.HttpServer;

public class MainApp {
    public static void main(String[] args) {
        HttpServer.create()
          .port(8080)
          .route(routes ->
                  routes.post("/test/{param}", (request, response) ->
                          response.sendString(request.receive()
                                                     .asString()
                                                     .map(s -> s + ' ' + request.param("param") + '!')
                                                     .log("http-server"))
                  )
          )
          .bindNow();
         System.out.println("Running on 8080"); 

         HttpClient.create()
          .port(8080)
          .post()               
          .uri("/test/World")   
          .send(ByteBufFlux.fromString(Flux.just("Hello")))  
          .responseContent()    
          .aggregate()
          .asString()
          .log("http-client")
          .block();
    }
}