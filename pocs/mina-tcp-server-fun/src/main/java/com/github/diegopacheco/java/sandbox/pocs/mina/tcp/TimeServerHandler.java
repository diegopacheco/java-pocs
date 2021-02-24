package com.github.diegopacheco.java.sandbox.pocs.mina.tcp;

import com.thoughtworks.xstream.XStream;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.util.Date;

public class TimeServerHandler extends IoHandlerAdapter {

    private XStream xstream = new XStream();

    public TimeServerHandler(){
        xstream.alias("date-response",DateResponse.class);
    }

    @Override
    public void exceptionCaught( IoSession session, Throwable cause ) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void messageReceived( IoSession session, Object message ) throws Exception {
        String str = message.toString();
        if( "</quit>".equalsIgnoreCase(str.trim()) ) {
            session.write( "bye" );
            session.closeOnFlush();
            return;
        }
        if("</time>".equalsIgnoreCase(str.trim()) ) {
            DateResponse response = new DateResponse();
            response.setDate(new Date());
            String xml = xstream.toXML(response);
            session.write(xml);
            System.out.println(getContextInfo(session) + "Message written... " + xml);
            return;
        }
        if("</options>".equalsIgnoreCase(str.trim()) ) {
            String result = "<options></time></quit></options>";
            session.write(result);
            System.out.println(getContextInfo(session) + result);
            return;
        }
        String result = "<error>Invalid options: "+str+"</error>";
        System.out.println(getContextInfo(session) + result);
        session.write(result);
        return;
    }
    @Override
    public void sessionIdle( IoSession session, IdleStatus status ) throws Exception {
        System.out.println(getContextInfo(session) + "IDLE " + session.getIdleCount( status ));
    }

    private String getContextInfo(IoSession session){
        return Thread.currentThread().getName() + " [" + session.getId() + "] ";
    }

}