package com.github.diegopacheco.sandbox.java.cass.dual.writer.dao;

import com.github.diegopacheco.sandbox.java.cass.dual.writer.connection.Cass3xConnectionManager;

public class Cass3xDAO extends BaseDAO {
	public Cass3xDAO() {
		connectionManager = Cass3xConnectionManager.getInstance();
		cluster = connectionManager.getCluster();
	}
}
