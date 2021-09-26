package com.github.diegopacheco.rsocket.reactive;

import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.SocketAcceptor;
import io.rsocket.core.RSocketConnector;
import io.rsocket.core.RSocketServer;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.transport.netty.server.TcpServerTransport;
import io.rsocket.util.DefaultPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class EchoMain {
    static final Logger logger = LoggerFactory.getLogger(EchoMain.class);

    public static void main(String[] args) {
        SocketAcceptor echoAcceptor =
                SocketAcceptor.forRequestChannel(
                        payloads ->
                                Flux.from(payloads)
                                        .map(Payload::getDataUtf8)
                                        .map(s -> "Echo: " + s)
                                        .map(DefaultPayload::create));

        RSocketServer.create(echoAcceptor).
                bindNow(TcpServerTransport.create("localhost", 7000));

        RSocket socket =
                RSocketConnector.
                        connectWith(TcpClientTransport.create("localhost", 7000)).
                        block();
        socket
                .requestChannel(
                        Flux.interval(Duration.ofMillis(1000)).
                                map(i -> DefaultPayload.create("Hello")))
                .map(Payload::getDataUtf8)
                .doOnNext(logger::info)
                .take(10)
                .doFinally(signalType -> socket.dispose())
                .then()
                .block();
    }
}
