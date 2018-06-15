package com.github.diegopacheco.sandbox.java.cass.dual.writer.connection;

import com.datastax.driver.core.Cluster;

public class Cass2xConnectionManager implements CassConnectionManager {
	
	private static Cass2xConnectionManager instance;
	
	private Cass2xConnectionManager() {}
	
	public synchronized static Cass2xConnectionManager getInstance() {
		if (instance==null)
			instance = new Cass2xConnectionManager();
		return instance;
	}
	
	public Cluster getCluster() {
		Cluster cluster = Cluster.builder()
        .withClusterName("cass2x_cluster")
        .addContactPoint("128.18.0.21")
        .addContactPoint("128.18.0.22")
        .addContactPoint("128.18.0.23")
        .build();
		return cluster;
	}
	
}
