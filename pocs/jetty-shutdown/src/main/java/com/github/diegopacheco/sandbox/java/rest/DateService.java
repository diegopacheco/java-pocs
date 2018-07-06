package com.github.diegopacheco.sandbox.java.rest;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("date")
public class DateService {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getDate() {
      return new Date().toString();
  }
	
}
