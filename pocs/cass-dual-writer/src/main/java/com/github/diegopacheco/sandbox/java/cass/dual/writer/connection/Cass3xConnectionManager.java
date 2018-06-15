package com.github.diegopacheco.sandbox.java.cass.dual.writer.connection;

import com.datastax.driver.core.Cluster;

public class Cass3xConnectionManager implements CassConnectionManager{
	
	private static Cass3xConnectionManager instance;
	
	private Cass3xConnectionManager() {}
	
	public synchronized static Cass3xConnectionManager getInstance() {
		if (instance==null)
			instance = new Cass3xConnectionManager();
		return instance;
	}
	
	public Cluster getCluster() {
		Cluster cluster = Cluster.builder()
        .withClusterName("cass3x_cluster")
        .addContactPoint("128.18.0.31")
        .addContactPoint("128.18.0.32")
        .addContactPoint("128.18.0.33")
        .build();
		return cluster;
	}
}
