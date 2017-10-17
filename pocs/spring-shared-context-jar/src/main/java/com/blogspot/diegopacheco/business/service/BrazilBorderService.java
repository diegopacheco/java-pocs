package com.blogspot.diegopacheco.business.service;


public class BrazilBorderService implements BorderService{

	@Override
	public String enterOrNot(String fromContry) {
		
		if(fromContry == null || "".endsWith(fromContry))
			throw new RuntimeException("Invalid parameter. fromContry must be not null!");
		
		if ("Cuba".toUpperCase().equals(fromContry.toUpperCase())){
			return "DENIED";
		}else{
			return "ACCEPT";
		}
	}
	
}
