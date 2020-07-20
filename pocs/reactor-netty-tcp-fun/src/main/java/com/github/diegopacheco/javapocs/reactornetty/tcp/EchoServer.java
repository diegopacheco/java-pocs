package com.github.diegopacheco.javapocs.reactornetty.tcp;

import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import reactor.netty.ByteBufFlux;
import reactor.netty.tcp.TcpServer;

public final class EchoServer {

    static final boolean SECURE = System.getProperty("secure") != null;
    static final int PORT = Integer.parseInt(System.getProperty("port", SECURE ? "8443" : "8080"));
    static final boolean WIRETAP = System.getProperty("wiretap") != null;

    public static void main(String[] args) throws Exception {
        TcpServer server =
                TcpServer.create()
                        .port(PORT)
                        .wiretap(WIRETAP)
                        .handle(
                                (in, out) -> {
                                    System.out.println("got... ");
                                    ByteBufFlux result = in.receive().retain();
                                    return out.send(result);
                                }
                        );

        if (SECURE) {
            SelfSignedCertificate ssc = new SelfSignedCertificate();
            server = server.secure(
                    spec -> spec.sslContext(SslContextBuilder.forServer(ssc.certificate(), ssc.privateKey())));
        }

        System.out.println("Running EchoServer... ");
        server.bindNow()
                .onDispose()
                .block();
    }
}