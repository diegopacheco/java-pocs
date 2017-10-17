package com.blogspot.diegopacheco.rest.cxf.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * CalculatorService is an contract definition about an REST caculator service.
 * 
 * @author Diego Pacheco
 * @since 08/08/2010
 * @version 1.0
 * 
 */
@Produces("text/html")
public interface CalculatorService {

	@GET
	@Path("/sum/{v1}/{v2}/")
	public Double sum(@PathParam("v1") Double value1,@PathParam("v2") Double value2);

	@GET
	@Path("/sub/{v1}/{v2}/")
	public Double sub(@PathParam("v1") Double value1,@PathParam("v2") Double value2);

	@GET
	@Path("/mul/{v1}/{v2}/")
	public Double mul(@PathParam("v1") Double value1,@PathParam("v2") Double value2);

	@GET
	@Path("/div/{v1}/{v2}/")
    @Produces("application/json")
	public Result div(@PathParam("v1") Double value1,@PathParam("v2") Double value2);

}
