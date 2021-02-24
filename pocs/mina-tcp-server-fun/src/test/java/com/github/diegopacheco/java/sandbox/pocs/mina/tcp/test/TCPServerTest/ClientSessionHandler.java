package com.github.diegopacheco.java.sandbox.pocs.mina.tcp.test.TCPServerTest;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientSessionHandler extends IoHandlerAdapter {

    private IoSession serverWritingSession;
    private Map<String,StringBuffer> sessionBuffers = new ConcurrentHashMap<>();

    public String askTime(){
        serverWritingSession.write("</time>");
        while(null==sessionBuffers.get(serverWritingSession.getId()+"")){
            SleepWell.sleepSilently(100);
        }
        String temp = sessionBuffers.get(serverWritingSession.getId()+"").toString();
        sessionBuffers.put(serverWritingSession.getId()+"",null);
        return temp;
    }

    @Override
    public void messageReceived(IoSession session, Object message ) throws Exception {
        System.out.println("CLIENT got : "+ message);
        if (null==sessionBuffers.get(session.getId())){
            sessionBuffers.put(session.getId()+"",new StringBuffer());
        }
        sessionBuffers.get(session.getId()+"").append((String)message);
    }

    public void setServerWritingSession(IoSession serverWritingSession) {
        this.serverWritingSession = serverWritingSession;
    }

}
