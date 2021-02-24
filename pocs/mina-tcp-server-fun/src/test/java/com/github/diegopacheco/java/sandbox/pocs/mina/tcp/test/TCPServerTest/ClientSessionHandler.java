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
        String sessionID = session.getId()+"";
        System.out.println("CLIENT got : "+ message + " - " + sessionID);
        if (null==sessionBuffers.get(sessionID) || Optional.empty().equals(sessionID)){
            sessionBuffers.put(sessionID,Optional.of(new StringBuffer()));
        }
        sessionBuffers.get(sessionID).get().append((String)message);
    }

    public void setServerWritingSession(IoSession serverWritingSession) {
        this.serverWritingSession = serverWritingSession;
    }

}
