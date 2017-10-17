package com.ilegra.training.apache.camel.routing.java;

public class JavaBeanHandler {
	
	public void handle(String message){
		System.out.println("JavaBeanHandler: "  + message);
	}
	
}
