package com.github.diegopacheco.sandbox.java.cass.dual.writer.dao;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.connection.CassConnectionManager;

public class BaseDAO implements CassDAO {
	
	protected CassConnectionManager connectionManager;
	
	public List<String> getAllData() {
		List<String> result = new ArrayList<>();
		Cluster cluster = connectionManager.getCluster();
		Session session = cluster.connect("cluster_test");
		for (Row row : session.execute("SELECT * FROM test")) {
			result.add(row.getString("key") + "-" + row.getString("value"));
		}
		session.close();
		return result;
	}

	public void insertData(String key, String value) {
		Cluster cluster = connectionManager.getCluster();
		Session session = cluster.connect("cluster_test");
		PreparedStatement prepared = session.prepare("INSERT INTO TEST (key,value) VALUES (?, ?);");
		BoundStatement bound = prepared.bind(key, value);
		session.execute(bound);
	}

}
