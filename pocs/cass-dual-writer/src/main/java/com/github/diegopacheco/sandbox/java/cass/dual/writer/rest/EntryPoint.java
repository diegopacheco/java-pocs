package com.github.diegopacheco.sandbox.java.cass.dual.writer.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.diegopacheco.sandbox.java.cass.dual.writer.core.toggle.TogglesManager;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.dao.Cass2xDAO;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.dao.DataFactory;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.dao.DualWriter;

@Path("/service")
public class EntryPoint {
	
	private DualWriter dualWriter = new DualWriter();
	private Cass2xDAO dao2x = new Cass2xDAO();
	private TogglesManager togglesManager = TogglesManager.getInstance();
	
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
  @Path("get/{k}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String insert(@PathParam("k") String key) {
  	return dualWriter.getById(key);
  }
  
  @GET
  @Path("all")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response getAll() {
  	List<String> data = dualWriter.getAllData();
  	Response response = Response.ok( data , MediaType.APPLICATION_JSON).build();
  	return response;
  }
  
  //
  // Dual Write + Forlift ADM ops
  //
	
  @GET
  @Path("sot")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response getSourceOfTruth() {
  	Response response = Response.ok( togglesManager.getSourceOfTruth().toString() , MediaType.APPLICATION_JSON).build();
  	return response;
  }
  
  @GET
  @Path("dw")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response getDualWrite(){
  	Response response = Response.ok( togglesManager.isDualWrtiteEnable() , MediaType.APPLICATION_JSON).build();
  	return response;
  }
  
  @GET
  @Path("dw/switch")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response setDualWriteOn(){
  	togglesManager.switchDualWrite();
  	Response response = Response.ok( togglesManager.isDualWrtiteEnable() , MediaType.APPLICATION_JSON).build();
  	return response;
  }
  
}
