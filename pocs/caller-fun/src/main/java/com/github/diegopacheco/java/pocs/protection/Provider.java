package com.github.diegopacheco.java.pocs.protection;

import com.github.diegopacheco.java.pocs.caller.RightCaller;

public class Provider {

    public int getAnswer(){
        String callerClass = Thread.currentThread().getStackTrace()[2].getClassName();
        System.out.println("Caller: " + callerClass);
        if (RightCaller.class.getName().equals(callerClass)){
            return 42;
        }
        throw new IllegalStateException("You should not be calling this! ");
    }
}