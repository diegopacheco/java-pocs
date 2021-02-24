package com.github.diegopacheco.java.sandbox.pocs.mina.tcp.test.TCPServerTest;

public class SleepWell {

    public static void sleepSilently(int timeInMS){
        try{
            Thread.sleep(timeInMS);
        }catch(Exception e){}
    }

}
