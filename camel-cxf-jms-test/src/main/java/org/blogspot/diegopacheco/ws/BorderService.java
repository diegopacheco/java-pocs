package org.blogspot.diegopacheco.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface BorderService {
	
	public String enter(@WebParam(name="ID")String ID,
						@WebParam(name="name")String name,
						@WebParam(name="fromCountry")String fromCountry
						);
}
