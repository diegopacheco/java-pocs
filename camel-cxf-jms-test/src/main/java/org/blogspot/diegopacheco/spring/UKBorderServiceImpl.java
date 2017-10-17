package org.blogspot.diegopacheco.spring;

import org.blogspot.diegopacheco.ws.BorderService;

public class UKBorderServiceImpl implements BorderService{
	
	@Override
	public String enter(String ID, String name, String fromCountry) {
		
		System.out.println("Real service reached! ");		
		String status = "Person with ID:" + ID + ", Name: " + name + ". Resolution: ";
		
		if("cuba".equals(fromCountry.toLowerCase())){
			status += "DENIED";
		}else{
			status += "PASS";
		}
		
		return status;
	}
	
	
	
}
