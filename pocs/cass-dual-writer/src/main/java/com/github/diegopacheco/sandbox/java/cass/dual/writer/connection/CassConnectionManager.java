package com.github.diegopacheco.sandbox.java.cass.dual.writer.connection;

import com.datastax.driver.core.Cluster;

public interface CassConnectionManager {
	public Cluster getCluster();
}
