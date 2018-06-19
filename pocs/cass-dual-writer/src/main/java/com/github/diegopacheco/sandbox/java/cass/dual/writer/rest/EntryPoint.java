package com.github.diegopacheco.sandbox.java.cass.dual.writer.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.diegopacheco.sandbox.java.cass.dual.writer.dao.Cass2xDAO;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.dao.DataFactory;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.dao.DualWriter;

@Path("/service")
public class EntryPoint {
	
	private DualWriter dualWriter = new DualWriter();
	private Cass2xDAO dao2x = new Cass2xDAO();
	
  @GET
  @Path("healthchecker")
  @Produces(MediaType.TEXT_PLAIN)
  public String healthchecker() {
      return "OK";
  }
  
  @GET
  @Path("generate/{records}")
  @Produces(MediaType.TEXT_PLAIN)
  public String count(@PathParam("records") Integer soManyRecords) {
  	System.out.println("Generating " + soManyRecords + " in Cass 2x.");
  	DataFactory df = new DataFactory();
  	df.generateRecords(soManyRecords, dao2x);
  	return "OK";
  }
  
  @GET
  @Path("insert/{k}/{v}")
  @Produces(MediaType.TEXT_PLAIN)
  public String insert(@PathParam("k") String key,@PathParam("v") String value) {
  	dualWriter.insertData(key, value);
  	return "OK";
  }
	
}
