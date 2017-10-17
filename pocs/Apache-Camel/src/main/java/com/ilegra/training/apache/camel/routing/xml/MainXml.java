package com.ilegra.training.apache.camel.routing.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXml {
	public static void main(String[] args) {		
		try{				
			new ClassPathXmlApplicationContext(new String[] {"classpath:spring-camel-routing-xml-beans.xml"});			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
