package com.github.diegopacheco.javapocs.reactornetty.http;

import reactor.core.publisher.Flux;
import reactor.netty.ByteBufFlux;

import java.util.function.Supplier;

public class HttpClient {

    private static reactor.netty.http.client.HttpClient.RequestSender sender = reactor.netty.http.client.HttpClient.create()
            .port(8080)
            .post()
            .uri("/test/World");

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            connectAndSendMSG("hello");
        }
        bench( () ->"ok this is the real deal?");
    }

    private static void bench(Supplier<String> code){
        try{
            long init = System.currentTimeMillis();
            connectAndSendMSG(code.get());
            long end = System.currentTimeMillis();
            System.out.println("Execution time: " + (end-init) + " ms");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private static void connectAndSendMSG(String msg){
        try{
            sender
                .send(ByteBufFlux.fromString(Flux.just(msg)))
                .responseContent()
                .aggregate()
                .asString()
                //.log("http-client")
                .block();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
