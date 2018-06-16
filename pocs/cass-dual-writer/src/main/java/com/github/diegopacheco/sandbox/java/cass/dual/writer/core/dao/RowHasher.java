package com.github.diegopacheco.sandbox.java.cass.dual.writer.core.dao;

import com.datastax.driver.core.Row;

public interface RowHasher {
	public String hash(Row row);
}
