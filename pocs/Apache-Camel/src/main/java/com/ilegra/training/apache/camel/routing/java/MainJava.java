package com.ilegra.training.apache.camel.routing.java;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainJava {
	public static void main(String[] args) {		
		try{				
			new ClassPathXmlApplicationContext(new String[] {"classpath:spring-camel-routing-java-beans.xml"});			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
