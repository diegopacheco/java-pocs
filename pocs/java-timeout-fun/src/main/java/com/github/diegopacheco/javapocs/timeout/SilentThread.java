package com.github.diegopacheco.javapocs.timeout;

public class SilentThread {

    public static void sleep(int timeInSec){
        try{
            Thread.sleep(timeInSec*1000);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
