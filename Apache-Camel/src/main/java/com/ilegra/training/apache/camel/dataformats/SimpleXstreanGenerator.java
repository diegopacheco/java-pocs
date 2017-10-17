package com.ilegra.training.apache.camel.dataformats;

import java.io.File;
import java.io.FileWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class SimpleXstreanGenerator {
	public static void main(String[] args) throws Throwable {
		
		DrugPojo dp = new DrugPojo();
		dp.setId( (long) (Math.random() *  100) );
		dp.setName("drug" + ((int)(Math.random() * 5)) );
		dp.setCompanyName("company " + ((int)(Math.random() * 10)) + " Inc. " );
		
		FileWriter fw = new FileWriter(new File("C:/tmp/dataformats.xml"));
		
		XStream xs = new XStream();
		xs.toXML(dp,fw);		
		System.out.println("XML Pojo XML generated.");
		
		fw = new FileWriter(new File("C:/tmp/dataformats.json"));		
		xs = new XStream(new JettisonMappedXmlDriver());
		xs.toXML(dp,fw);
		System.out.println("XML Pojo JSON generated.");
	}
}
