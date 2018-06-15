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
	protected Cluster cluster;
	
	private static Session session;
	private static PreparedStatement prepared;
	
	public List<String> getAllData() {
		List<String> result = new ArrayList<>();
		Session session = getSession(cluster);
		for (Row row : session.execute("SELECT * FROM test")) {
			result.add(row.getString("key") + "-" + row.getString("value"));
		}
		return result;
	}

	public void insertData(String key, String value) {
		Session session = getSession(cluster);
		prepared = getPreparedStatement(cluster);
		BoundStatement bound = prepared.bind(key, value);
		session.execute(bound);
	}
	
	private synchronized static PreparedStatement getPreparedStatement(Cluster cluster) {
		Session session = getSession(cluster);
		if (prepared==null) {
			prepared = session.prepare("INSERT INTO TEST (key,value) VALUES (?, ?);");
		}
		return prepared;
	}
	
	private synchronized static Session getSession(Cluster cluster) {
		if (session==null) {
			session = cluster.connect("cluster_test");
		}
		return session;
	}

}
