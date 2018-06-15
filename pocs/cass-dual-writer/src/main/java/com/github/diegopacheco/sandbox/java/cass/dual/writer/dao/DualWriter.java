package com.github.diegopacheco.sandbox.java.cass.dual.writer.dao;

import java.util.List;

public class DualWriter implements CassDAO{
	
	private CassDAO dao2x = new Cass2xDAO();
	private CassDAO dao3x = new Cass3xDAO();
	
	@Override
	public void insertData(String key, String value) {
		
		try{
			dao2x.insertData(key, value);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}

		try {
			dao3x.insertData(key, value);
		}catch(Exception e) {
			// Here we such it up since cass 3x is not source of truth and fork lifter will catch that :D
			System.out.println("Error to write on cass 3x: " + e);
		}
		
	}	
	
	@Override
	public List<String> getAllData() {
		throw new RuntimeException("we dont need read on dual writter");
	}
	
	public static void main(String[] args) {
		DualWriter dw = new DualWriter();
		dw.insertData("x1", "v1");
		System.out.println("DONE");
	}
	
}
