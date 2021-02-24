package com.github.diegopacheco.java.sandbox.pocs.mina.tcp.test.TCPServerTest;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class ClientSessionHandler extends IoHandlerAdapter {

    private IoSession serverWritingSession;
    private StringBuffer result;

    public String askTime(){
        serverWritingSession.write("</time>");
        while(null==result){
            SleepWell.sleepSilently(100);
        }
        String temp = result.toString();
        result = null;
        return temp;
    }

    @Override
    public void messageReceived(IoSession session, Object message ) throws Exception {
        System.out.println("CLIENT got : "+ message);
        if (null==result){
            result = new StringBuffer();
        }
        result.append((String)message);
    }

    public void setServerWritingSession(IoSession serverWritingSession) {
        this.serverWritingSession = serverWritingSession;
    }

}
