package com.github.diegopacheco.sandbox.java.cass.dual.writer.dao;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.connection.CassConnectionManager;

public class BaseDAO implements BusinessDAO, CassDAO {
	
	protected CassConnectionManager connectionManager;
	protected Cluster cluster;
	
	private Session session;
	private PreparedStatement prepared;
	
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
	
	private synchronized PreparedStatement getPreparedStatement(Cluster cluster) {
		Session session = getSession(cluster);
		if (prepared==null) {
			prepared = session.prepare("INSERT INTO TEST (key,value) VALUES (?, ?);");
		}
		return prepared;
	}
	
	private synchronized Session getSession(Cluster cluster) {
		if (session==null) {
			session = cluster.connect("cluster_test");
		}
		return session;
	}
	
	@Override
	public List<Row> getAllDataAsRow(){
		List<Row> result = new ArrayList<>();
		Session session = getSession(cluster);
		for (Row row : session.execute("SELECT * FROM test")) {
			result.add(row);
		}
		return result;
	}
	
	@Override
	public void insertDataFromRow(Row row) {
		Session session = getSession(cluster);
		prepared = getPreparedStatement(cluster);
		BoundStatement bound = prepared.bind(row.getString("key"), row.getString("value"));
		session.execute(bound);
	}

}
