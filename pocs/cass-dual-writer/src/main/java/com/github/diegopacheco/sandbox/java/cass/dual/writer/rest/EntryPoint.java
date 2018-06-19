package com.github.diegopacheco.sandbox.java.cass.dual.writer.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.diegopacheco.sandbox.java.cass.dual.writer.core.forklift.DaoPairs;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.core.forklift.ForkLiftMetricsManager;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.core.forklift.ForkLifter;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.core.toggle.TogglesManager;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.dao.Cass2xDAO;
import com.github.diegopacheco.sandbox.java.cass.dual.writer.dao.Cass3xDAO;
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
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response getOptions() {
  	Map<String,String> data = new HashMap<>();
  	data.put("/", "Show all options - all things you can do");
    data.put("/healthchecker", "/Service Healthcechker operation.");
    data.put("/generate/{records}", "Generate as many records as you want! ");
    data.put("/insert/{k}/{v}", "Insert a single record");
    data.put("/get/{k}", "Get a single record by id");
    data.put("/all", "Get All data in DB");
    data.put("/sot", "Tells who is the database source of truth");
    data.put("/dw", "Tells if DUAL.WRITE is ON or OFF");
    data.put("/dw/switch", "FLIPS DUAL.WRITE");
    data.put("/fl", "Tells if FORKLIFT is ON or OFF");
    data.put("/fl/stats", "Provide internal statistic about ForkLift");
    data.put("/fl/switch", "FLIPS FORKLIFT");
    
  	Response response = Response.ok( data , MediaType.APPLICATION_JSON).build();
  	return response;
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
  
  @GET
  @Path("fl")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response getForkLift(){
  	Response response = Response.ok( togglesManager.isForkLift(), MediaType.APPLICATION_JSON).build();
  	return response;
  }
  
  @GET
  @Path("fl/stats")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response getForkLiftStats(){
  	Response response = Response.ok( ForkLiftMetricsManager.getIntansce()  , MediaType.APPLICATION_JSON).build();
  	return response;
  }
  
  @GET
  @Path("fl/switch")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response setForkLift(){
  	boolean isForkLiftOn = togglesManager.switchForkLift();
  	Response response = Response.ok( togglesManager.isForkLift() , MediaType.APPLICATION_JSON).build();
  	
  	if(isForkLiftOn) {
  		ForkLifter fl = ForkLifter.getInstance();
  		fl.addDaoPair(new DaoPairs(new Cass2xDAO(), new Cass3xDAO()));
  	}else {
  		ForkLifter fl = ForkLifter.getInstance();
  		fl.gracefulStop();
  	}
  	
  	return response;
  }
  
}
