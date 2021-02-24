package com.github.diegopacheco.java.sandbox.pocs.mina.tcp;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class TCPServer {
    private static final int PORT = 9000;
    public static void main( String[] args ) throws IOException {

        System.out.println("████████  ██████ ██████  ███████ ███████ ██████  ██    ██ ███████ ██████  \n" +
                "   ██    ██      ██   ██ ██      ██      ██   ██ ██    ██ ██      ██   ██ \n" +
                "   ██    ██      ██████  ███████ █████   ██████  ██    ██ █████   ██████  \n" +
                "   ██    ██      ██           ██ ██      ██   ██  ██  ██  ██      ██   ██ \n" +
                "   ██     ██████ ██      ███████ ███████ ██   ██   ████   ███████ ██   ██ \n" +
                "                                                                          ");
        System.out.println("try: $ telnet 127.0.0.1 9000 ");
        System.out.println("them: </time> or </options> or </quit>");

        IoAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast( "logger", new LoggingFilter("TCPServer") );
        acceptor.getFilterChain().addLast( "codec",
                new ProtocolCodecFilter( new TextLineCodecFactory( Charset.forName( "UTF-8" ),"\n","\n")));
        acceptor.setHandler( new TimeServerHandler() );

        acceptor.getSessionConfig().setReadBufferSize( 2048 );
        acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE, 10 );
        acceptor.bind( new InetSocketAddress(PORT) );
    }
}