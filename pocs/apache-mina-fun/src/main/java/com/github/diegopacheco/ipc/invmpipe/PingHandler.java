package com.github.diegopacheco.ipc.invmpipe;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import java.util.UUID;

public class PingHandler extends IoHandlerAdapter {

    private String id = UUID.randomUUID().toString();

    @Override
    public void sessionOpened(IoSession session) {
        System.out.println("PingHandler-" + id + ": READY");
    }

    @Override
    public void sessionClosed(IoSession session) {
        System.out.println("PingHandler-" + id + ": QUIT");
    }

    @Override
    public void messageReceived(IoSession session, Object message) {
        System.out.println("PingHandler-" + id + ": RCVD " + message);
        PingRequest pr = (PingRequest)message;
        if (!pr.isPong()){
            pr.setPong(true);
            session.write(pr);
        }else{
            System.out.println("PingHandler-" + id + ": LOSE");
            session.closeNow();
        }
    }

}
