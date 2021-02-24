package com.github.diegopacheco.java.sandbox.pocs.mina.tcp.test.TCPServerTest;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class ClientSessionHandler extends IoHandlerAdapter {

    private IoSession serverWritingSession;

    public void askTime(){
        serverWritingSession.write("</time>");
    }

    @Override
    public void messageReceived(IoSession session, Object message ) throws Exception {
        System.out.println(message);
    }

    public void setServerWritingSession(IoSession serverWritingSession) {
        this.serverWritingSession = serverWritingSession;
    }

}
