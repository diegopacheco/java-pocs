package com.github.diegopacheco.javapocs.reactornetty.tcp;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufFlux;
import reactor.netty.Connection;
import reactor.netty.tcp.TcpClient;

import java.util.UUID;

public final class EchoClient {

    static final boolean SECURE = System.getProperty("secure") != null;
    static final int PORT = Integer.parseInt(System.getProperty("port", SECURE ? "8443" : "8080"));
    static final boolean WIRETAP = System.getProperty("wiretap") != null;

    public static void main(String[] args) {
        TcpClient client =
                TcpClient.create()
                        .port(PORT)
                        .wiretap(WIRETAP);

        if (SECURE) {
            client = client.secure(
                    spec -> spec.sslContext(SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE)));
        }

        sendMessage(client);
    }

    private static void sendMessage(TcpClient client){
        try{
            Connection connection = client.handle((in, out) -> {
                String message = "echo_"+ UUID.randomUUID().toString();
                System.out.println("Sending message... " + message);
                return out.sendString(Mono.just(message));
            }).connectNow();
            connection.onDispose().block();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}