package com.github.diegopacheco.sandbox.java.cass.dual.writer.dao;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.connection.CassConnectionManager;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.core.dao.CassDAO;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.core.dao.HashComparableRow;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.core.dao.RowHasher;

public class BaseDAO implements BusinessDAO, CassDAO {
	
	protected CassConnectionManager connectionManager;
	protected Cluster cluster;
	
	private Session session;
	private PreparedStatement prepared;
	
	//
	// Regular Business Methods
	//
	
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
	
	@Override
	public String getById(String id) {
		Session session = getSession(cluster);
		ResultSet rs = session.execute("SELECT * FROM test WHERE KEY='" + id + "'");
		Row r = rs.all().get(0);
		return r.getString("key") + ":" + r.getString("value") ;
	}

	
	//
	// Simple caching
	//
	
	
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
	
	//
	// Fork Lifting methods 
	//
	
	private RowHasher hasher = new RowHasher() {
		@Override
		public String hash(Row row) {
			String key = row.getString("key");
			String value = row.getString("value");
			String hash   = (key!=null) ? key.hashCode() + "" : "";
						 hash  += (value!=null) ? value.hashCode() + "" : "";
			return hash;
		}
	};
	
	@Override
	public RowHasher getRowHasher() {
		return hasher;
	}
	
	@Override
	public ResultSet getReadResultSet() {
		SimpleStatement statement = new SimpleStatement("select * from TEST");
		//statement.setFetchSize(100);
		Session session = getSession(cluster);
		ResultSet rs = session.execute(statement);
		return rs;
	}
	
	@Override
	public void insertData(HashComparableRow row) {
		Session session = getSession(cluster);
		prepared = getPreparedStatement(cluster);
		BoundStatement bound = prepared.bind(row.getOriginalRow().getString("key"), row.getOriginalRow().getString("value"));
		session.execute(bound);
	}
	
}
