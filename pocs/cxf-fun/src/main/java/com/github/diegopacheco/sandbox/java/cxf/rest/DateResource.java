package com.github.diegopacheco.sandbox.java.cxf.rest;

import java.util.Date;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.stereotype.Service;

@Service
@ApplicationPath("date")
public class DateResource extends Application implements DateService{ 
	
	@GET
	@Path("/now")
	@Produces("text/plain")
	@Override
	public Response getDate() {
	   ResponseBuilder response=Response.ok(new Date().toString());
	   return response.build();
	}
	
}
