package com.github.diegopacheco.java.sandbox.pocs.mina.tcp.test.TCPServerTest;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ClientSessionHandler extends IoHandlerAdapter {

    private IoSession serverWritingSession;
    private Map<String, Optional<StringBuffer>> sessionBuffers = new ConcurrentHashMap<>();

    public String askTime(){
        String sessionID = serverWritingSession.getId()+"";
        serverWritingSession.write("</time>");
        while(null==sessionBuffers.get(sessionID) || Optional.empty().equals(sessionBuffers.get(sessionID))){
            SleepWell.sleepSilently(100);
        }
        String temp = sessionBuffers.get(sessionID).get().toString();
        sessionBuffers.put(sessionID,Optional.empty());
        return temp;
    }

    @Override
    public void messageReceived(IoSession session, Object message ) throws Exception {
        System.out.println("CLIENT got : "+ message);
        if (null==sessionBuffers.get(session.getId()) || Optional.empty().equals(sessionBuffers.get(session.getId()))){
            sessionBuffers.put(session.getId()+"",Optional.of(new StringBuffer()));
        }
        sessionBuffers.get(session.getId()+"").get().append((String)message);
    }

    public void setServerWritingSession(IoSession serverWritingSession) {
        this.serverWritingSession = serverWritingSession;
    }

}
