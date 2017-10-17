package com.github.diegopacheco.sandbox.java.netflixoss.karyon.poc.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import netflix.karyon.health.HealthCheckHandler;

@Path("/healthcheck")
public class HealthcheckResource implements HealthCheckHandler{
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response healthcheck() {
        return Response.status(getStatus()).build();
    }

	@Override
	public int getStatus() {
		return 200;
	}
	
}
