package com.ilegra.training.apache.camel.dataformats;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDateFormats {
	public static void main(String[] args) {		
		try{				
			new ClassPathXmlApplicationContext(new String[] {"classpath:spring-camel-dataformats-beans.xml"});			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
