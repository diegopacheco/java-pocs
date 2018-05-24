package com.github.diegopacheco.java.sandbox.paldb.poc;

import java.io.File;
import java.util.Arrays;
import java.util.Map;

import com.linkedin.paldb.api.PalDB;
import com.linkedin.paldb.api.StoreReader;
import com.linkedin.paldb.api.StoreWriter;

public class Main {
	public static void main(String[] args) {
			
		StoreWriter writer = PalDB.createWriter(new File("store.paldb"));
		writer.put("foo", "bar");
		writer.put(1213, new int[] {1, 2, 3});
		writer.close();
		
		StoreReader reader = PalDB.createReader(new File("store.paldb"));
		String val1 = reader.get("foo");
		System.out.println("foo = " + val1);
		
		int[] val2 = reader.get(1213);
		System.out.println("foo = " + Arrays.toString(val2));
		reader.close();
		
		reader = PalDB.createReader(new File("store.paldb"));
		Iterable<Map.Entry<String, String>> iterable = reader.iterable();
		for (Map.Entry<String, String> entry : iterable) {
		  Object key = entry.getKey();
		  Object value = entry.getValue();
		  System.out.println("Key: " + key + " value: " + value);
		}
		reader.close();
		
	}
}
