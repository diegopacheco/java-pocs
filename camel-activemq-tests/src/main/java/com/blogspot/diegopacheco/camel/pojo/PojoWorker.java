package com.blogspot.diegopacheco.camel.pojo;

import org.springframework.stereotype.Service;

import com.thoughtworks.xstream.XStream;

@Service("PojoWorker")
public class PojoWorker implements Worker {
	
	public void doWork(String message){
		
		System.out.println("Trabalhando com:" + message);
		
//		XStream xs = new XStream();
//		xs.alias("person", Person.class);		
//		Person p = (Person)xs.fromXML(message);
		
//		System.out.println("Pojo: " + p.toString());
	}
}
