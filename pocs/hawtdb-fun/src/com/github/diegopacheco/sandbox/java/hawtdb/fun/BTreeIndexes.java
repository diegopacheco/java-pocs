package com.github.diegopacheco.sandbox.java.hawtdb.fun;

import java.io.File;

import org.fusesource.hawtdb.api.BTreeIndexFactory;
import org.fusesource.hawtdb.api.Index;
import org.fusesource.hawtdb.api.Transaction;
import org.fusesource.hawtdb.api.TxPageFile;
import org.fusesource.hawtdb.api.TxPageFileFactory;

public class BTreeIndexes {
	public static void main(String[] args) {
		
		TxPageFileFactory factory = new TxPageFileFactory();
		factory.setFile(new File("mydbtx.dat"));
		factory.open();
		
		TxPageFile pageFile = factory.getTxPageFile();		
		BTreeIndexFactory<String, String> indexFactory = new BTreeIndexFactory<String, String>();

		Transaction tx = pageFile.tx();
		Index<String, String> root = indexFactory.openOrCreate(tx);
		root.put("1", "Test HawtDB");
		tx.commit();
		
		String result = root.get("1");
		System.out.println(result);		
	}
}
