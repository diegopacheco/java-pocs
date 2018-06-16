package com.github.diegopacheco.sandbox.java.cass.dual.writer.core.dao;

import java.util.List;

import com.datastax.driver.core.Row;

public interface CassDAO {
	public List<HashComparableRow> getAllDataAsRow();
	public void insertDataFromRow(Row row);
	public RowHasher getRowHasher();
}