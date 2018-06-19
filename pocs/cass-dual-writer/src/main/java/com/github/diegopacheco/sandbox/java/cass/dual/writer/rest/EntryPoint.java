package com.github.diegopacheco.sandbox.java.cass.dual.writer.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.diegopacheco.sandbox.java.cass.dual.writer.dao.Cass2xDAO;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.dao.DataFactory;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.dao.DualWriter;

@Path("/service")
public class EntryPoint {
	
	private DualWriter dualWriter = new DualWriter();
	private Cass2xDAO dao2x = new Cass2xDAO();
	
  @GET
  @Path("healthchecker")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String healthchecker() {
      return "OK";
  }
  
  @GET
  @Path("generate/{records}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String count(@PathParam("records") Integer soManyRecords) {
  	System.out.println("Generating " + soManyRecords + " in Cass 2x.");
  	DataFactory df = new DataFactory();
  	df.generateRecords(soManyRecords, dao2x);
  	return "OK";
  }
  
  @GET
  @Path("insert/{k}/{v}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String insert(@PathParam("k") String key,@PathParam("v") String value) {
  	dualWriter.insertData(key, value);
  	return "OK";
  }
  
  @GET
  @Path("all")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response getAll() {
  	List<String> data = dualWriter.getAllData();
  	Response response = Response.ok( new Result(data) , MediaType.APPLICATION_JSON).build();
  	return response;
  }
	
}
