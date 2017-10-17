package com.blogspot.diegopacheco.business.service;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("portugualBorderService")
public class PortugualBorderService implements BorderService {
	
	@Override
	public String enterOrNot(String fromContry) {
		
		if(fromContry == null || "".endsWith(fromContry))
			throw new RuntimeException("Invalid parameter. fromContry must be not null!");
			
		if ("Bolivia".toUpperCase().equals(fromContry.toUpperCase())){
			return "DENIED";
		}else{
			return "ACCEPT";
		}
	}
	
}
