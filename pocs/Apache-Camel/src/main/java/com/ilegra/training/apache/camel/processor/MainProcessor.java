package com.ilegra.training.apache.camel.processor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProcessor {
	public static void main(String[] args) {		
		try{				
			new ClassPathXmlApplicationContext(new String[] {"classpath:spring-camel-processor-beans.xml"});			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
