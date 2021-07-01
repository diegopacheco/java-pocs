package com.github.diegopacheco.javapocs.agent;

import java.lang.instrument.Instrumentation;
import java.util.UUID;

public class Agent {

    public static void premain(String agentArgs, Instrumentation inst) {
        final String id = UUID.randomUUID().toString();
        System.out.println("[premain] Agent ID["+id+"] running before main app... ");
        new Thread(){
            @Override
            public void run() {
                while(true){
                    try{
                        System.out.println("Agent ID["+id+"] running... ");
                        Thread.sleep(3000L);
                    }catch(Exception e){}
                }
            }
        }.start();
    }

    public static void agentmain(String agentArgs, Instrumentation inst) {
        String id = UUID.randomUUID().toString();
        System.out.println("[agentmain] Agent ID["+id+"] running before main app... ");
    }

}
