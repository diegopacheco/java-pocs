package com.blogspot.diegopacheco.cxf.cglib.contract.def;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface TimeService{

	@WebMethod
	public TimeOutput getTime(@WebParam String name);

	@WebMethod
	public TimeOutput getDateAndTime(@WebParam TimeInput drugInput);

	@WebMethod
	public @WebResult(name="token") String getDate(@WebParam TimeInput drugInput);	

	@WebMethod
	public TimeOutput dateTimeFromMoon(@WebParam String token);

}
