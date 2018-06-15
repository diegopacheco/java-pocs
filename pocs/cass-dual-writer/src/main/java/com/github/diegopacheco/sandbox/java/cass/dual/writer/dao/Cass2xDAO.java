package com.github.diegopacheco.sandbox.java.cass.dual.writer.dao;

import com.github.diegopacheco.sandbox.java.cass.dual.writer.connection.Cass2xConnectionManager;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.data.DataFactory;

public class Cass2xDAO extends BaseDAO {
	
	public Cass2xDAO(){
		connectionManager = Cass2xConnectionManager.getInstance();
		cluster = connectionManager.getCluster();
	}
	
	public static void main(String[] args) {
			Cass2xDAO dao = new Cass2xDAO();
			
			System.out.println("Insert all data in CASS 2.x");
			DataFactory df = new DataFactory();
			df.generateRecords(1500000, dao);
			
			System.out.println("Listing all data in CASS 2.x");
			System.out.println("Cass 2x. now has: " + dao.getAllData().size() + " keys");			
	}
	
}
