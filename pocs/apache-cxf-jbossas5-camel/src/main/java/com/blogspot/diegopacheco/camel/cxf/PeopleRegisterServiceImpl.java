package com.blogspot.diegopacheco.camel.cxf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;

import com.thoughtworks.xstream.XStream;

public class PeopleRegisterServiceImpl implements PeopleRegisterService{
	
	@Produce(uri = "activemq:queue:QDados")
    ProducerTemplate producer;
	
	public void register(String firstName, String lastName,String city){
	
		Person pojo = new Person(firstName, lastName, city);
		XStream xs = new XStream();
		
		try {			
			xs.toXML(pojo,new FileOutputStream(new File("target/xstream-data")));
			
			producer.sendBody(xs.toXML(pojo));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Fim do trabalho... ");
		}
	}
	
}
