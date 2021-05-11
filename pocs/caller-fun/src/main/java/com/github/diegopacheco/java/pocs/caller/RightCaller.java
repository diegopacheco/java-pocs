package com.github.diegopacheco.java.pocs.caller;

import com.github.diegopacheco.java.pocs.protection.Provider;

public class RightCaller {

    public void printCall(){
        Provider p = new Provider();
        System.out.println("Answer: " + p.getAnswer());
    }

}
