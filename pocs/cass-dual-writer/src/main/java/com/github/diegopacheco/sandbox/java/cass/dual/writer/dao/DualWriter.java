package com.github.diegopacheco.sandbox.java.cass.dual.writer.dao;

import java.util.List;

import com.github.diegopacheco.sandbox.java.cass.dual.writer.core.toggle.TogglesManager;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.core.toggle.TogglesProps.SourceOfTruth;

public class DualWriter implements BusinessDAO{
	
	private BusinessDAO dao2x = new Cass2xDAO();
	private BusinessDAO dao3x = new Cass3xDAO();
	private TogglesManager togglesManager = TogglesManager.getInstance();
	
	@Override
	public void insertData(String key, String value) {
		
		SourceOfTruth sot = togglesManager.getSourceOfTruth();
		if (sot==SourceOfTruth.CASS2x) {
			
			try{
				dao2x.insertData(key, value);
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
			
		}else {
			
			try{
				dao3x.insertData(key, value);
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
			
		}

		if (togglesManager.isDualWrtiteEnable()) {
			try {
				dao3x.insertData(key, value);
			}catch(Exception e) {
				// Here we such it up since cass 3x is not source of truth and fork lifter will catch that :D
				System.out.println("Error to write on cass 3x: " + e);
			}
		}		
	}	
	
	@Override
	public List<String> getAllData() {
		SourceOfTruth sot = togglesManager.getSourceOfTruth();
		if (sot==SourceOfTruth.CASS2x) {
			return dao2x.getAllData();
		}else {
			return dao3x.getAllData();
		}
	}

	@Override
	public String getById(String id) {
		SourceOfTruth sot = togglesManager.getSourceOfTruth();
		if (sot==SourceOfTruth.CASS2x) {
			return dao2x.getById(id);
		}else {
			return dao3x.getById(id);
		}
	}
	
}
