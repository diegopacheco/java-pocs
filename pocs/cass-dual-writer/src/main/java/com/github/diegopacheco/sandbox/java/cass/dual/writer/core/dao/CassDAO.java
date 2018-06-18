package com.github.diegopacheco.sandbox.java.cass.dual.writer.core.dao;

import com.datastax.driver.core.ResultSet;

public interface CassDAO {
	
	public ResultSet getReadResultSet();

	public RowHasher getRowHasher();
	
	public void insertData(HashComparableRow row);
	
}