package com.github.diegopacheco.sandbox.java.guice4.servlet.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/info")
public class InfoResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld() {
		return "F.Y.I this is REST";
	}

}
