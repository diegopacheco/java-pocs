package com.github.diegopacheco.sandbox.java.cass.dual.writer.core.forklift;

import java.util.Iterator;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;

public class RSOnDemand {
	public static void main(String[] args) {
		
		Cluster cluster = Cluster.builder()
        .withClusterName("cass2x_cluster")
        .addContactPoint("128.18.0.21")
        .addContactPoint("128.18.0.22")
        .addContactPoint("128.18.0.23")
        .build();
		
		Session session = cluster.connect("cluster_test");
		Statement stmt = new SimpleStatement("SELECT * FROM TEST");
		stmt.setFetchSize(100);
		ResultSet rs = session.execute(stmt);
		System.out.println(rs.isFullyFetched());
		
		Iterator<Row> iter = rs.iterator();
		while (!rs.isFullyFetched()) {
		  rs.fetchMoreResults();
		  Row row = iter.next();
		  System.out.println(row);
		}
		
		cluster.close();
		
	}
}
