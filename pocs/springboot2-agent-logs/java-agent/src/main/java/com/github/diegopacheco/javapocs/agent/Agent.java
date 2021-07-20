package com.github.diegopacheco.javapocs.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.instrument.Instrumentation;
import java.util.UUID;

public class Agent {

    private static Logger logger = LoggerFactory.getLogger(Agent.class);

    public static void premain(String agentArgs, Instrumentation inst) {
        final String id = UUID.randomUUID().toString();
        logger.info("[premain] Agent ID["+id+"] running before main app... ");
        Thread t = new Thread(){
            @Override
            public void run() {
                while(true){
                    try{
                        logger.debug("Agent ID["+id+"] running... ");
                        Thread.sleep(1000L);
                    }catch(Throwable t){
                        t.printStackTrace();
                        logger.error("fail to run ",t);
                    }
                }
            }
        };
        t.setDaemon(true);
        t.start();
    }

    public static void agentmain(String agentArgs, Instrumentation inst) {
        String id = UUID.randomUUID().toString();
        logger.info("[agentmain] Agent ID["+id+"] running before main app... ");
    }

}
