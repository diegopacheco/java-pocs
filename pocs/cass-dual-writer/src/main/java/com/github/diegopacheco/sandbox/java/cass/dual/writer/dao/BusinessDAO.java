package com.github.diegopacheco.sandbox.java.cass.dual.writer.dao;

import java.util.List;

public interface BusinessDAO {
	public List<String> getAllData();
	public void insertData(String key, String value);
	public String getById(String id);
}
