package com.github.diegopacheco.sandbox.java.mbassador;

import java.io.File;

import net.engio.mbassy.listener.Handler;

public class SimpleFileListener {
	
    @Handler
    public void handle(File msg){
    	System.out.println("GOT : " + msg);
    }
	
}
