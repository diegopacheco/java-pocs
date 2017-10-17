package com.github.diegopacheco.sandbox.java.hawtdb.fun;

import java.io.File;

import org.fusesource.hawtdb.api.HashIndexFactory;
import org.fusesource.hawtdb.api.Index;
import org.fusesource.hawtdb.api.PageFile;
import org.fusesource.hawtdb.api.PageFileFactory;

public class HashIndexes {
	public static void main(String[] args) {
		
		PageFileFactory factory = new PageFileFactory();
		factory.setFile(new File("mydb.dat"));
		factory.open();
		
		PageFile pageFile = factory.getPageFile();
		HashIndexFactory<String, String> indexFactory = new HashIndexFactory<String, String>();
		Index<String, String> root = indexFactory.create(pageFile);
		
		root.put("1", "Test HawtDB");
		root.put("2", "Embedded NoSQL rocks !!!");
		
		String result = root.get("1");
		System.out.println(result);
	}
}
