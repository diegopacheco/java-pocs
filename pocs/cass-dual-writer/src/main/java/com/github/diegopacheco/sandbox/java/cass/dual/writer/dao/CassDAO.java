package com.github.diegopacheco.sandbox.java.cass.dual.writer.dao;

import java.util.List;

import com.datastax.driver.core.Row;

public interface CassDAO {
	public List<Row> getAllDataAsRow();
	public void insertDataFromRow(Row row);
}