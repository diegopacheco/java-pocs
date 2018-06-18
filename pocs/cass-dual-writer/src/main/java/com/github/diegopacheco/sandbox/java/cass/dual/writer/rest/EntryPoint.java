package com.github.diegopacheco.sandbox.java.cass.dual.writer.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/service")
public class EntryPoint {
	
  @GET
  @Path("healthchecker")
  @Produces(MediaType.TEXT_PLAIN)
  public String healthchecker() {
      return "OK";
  }
	
}
