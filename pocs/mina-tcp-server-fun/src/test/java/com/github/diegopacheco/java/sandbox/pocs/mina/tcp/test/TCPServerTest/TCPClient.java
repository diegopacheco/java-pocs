package com.github.diegopacheco.java.sandbox.pocs.mina.tcp.test.TCPServerTest;

import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class TCPClient {
    public static void main(String[] args) throws Throwable {

        System.out.println("████████╗ ██████╗██████╗  ██████╗██╗     ██╗███████╗███╗   ██╗████████╗\n" +
                "╚══██╔══╝██╔════╝██╔══██╗██╔════╝██║     ██║██╔════╝████╗  ██║╚══██╔══╝\n" +
                "   ██║   ██║     ██████╔╝██║     ██║     ██║█████╗  ██╔██╗ ██║   ██║   \n" +
                "   ██║   ██║     ██╔═══╝ ██║     ██║     ██║██╔══╝  ██║╚██╗██║   ██║   \n" +
                "   ██║   ╚██████╗██║     ╚██████╗███████╗██║███████╗██║ ╚████║   ██║   \n" +
                "   ╚═╝    ╚═════╝╚═╝      ╚═════╝╚══════╝╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   \n" +
                "                                                                      ");
        System.out.println("connected on 127.0.0.1 9000 ");

        NioSocketConnector connector = new NioSocketConnector();
        connector.setConnectTimeoutMillis(3000);

        connector.getFilterChain().addLast( "logger", new LoggingFilter("TCPServer") );
        connector.getFilterChain().addLast( "codec",
                new ProtocolCodecFilter( new TextLineCodecFactory( Charset.forName( "UTF-8" ),"\n","\n")));

        ClientSessionHandler clientHandler = new ClientSessionHandler();
        connector.setHandler(clientHandler);
        IoSession session;

        for (;;) {
            try {
                ConnectFuture future = connector.connect(new InetSocketAddress("127.0.0.1", 9000));
                future.awaitUninterruptibly();
                session = future.getSession();
                clientHandler.setServerWritingSession(session);
                break;
            } catch (RuntimeIoException e) {
                System.err.println("Failed to connect.");
                e.printStackTrace();
                Thread.sleep(5000);
            }
        }

        clientHandler.askTime();

        session.getCloseFuture().awaitUninterruptibly();
        connector.dispose();
    }
}
