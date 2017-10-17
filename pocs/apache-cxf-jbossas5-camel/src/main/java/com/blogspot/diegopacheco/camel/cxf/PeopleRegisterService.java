package com.blogspot.diegopacheco.camel.cxf;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://diego-pacheco.bogspot/prs/v1", name = "prs")
public interface PeopleRegisterService {
	
	public void register(@WebParam(name = "firstName") String firstName, 
						 @WebParam(name = "lastName")  String lastName,
						 @WebParam(name = "city")  	   String city);
	
}
