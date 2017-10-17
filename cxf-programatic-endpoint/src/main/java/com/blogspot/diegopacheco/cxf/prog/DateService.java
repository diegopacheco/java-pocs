package com.blogspot.diegopacheco.cxf.prog;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface DateService {
	
	@WebMethod
	@WebResult(name = "dataResult")
	public String checkCurrentDate();
	
}
