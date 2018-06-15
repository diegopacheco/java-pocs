package com.github.diegopacheco.sandbox.java.cass.dual.writer.dao;

import java.util.List;

public interface CassDAO {
	public List<String> getAllData();
	public void insertData(String key, String value);
	
	// if this guy return the table metadata we can do it.
	// also need proper object for key, and linkedlist with all values in insertion order
	// so there are method to get the key and get values to that key.
}
