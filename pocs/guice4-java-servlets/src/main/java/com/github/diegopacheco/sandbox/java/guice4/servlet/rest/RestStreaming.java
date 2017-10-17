package com.github.diegopacheco.sandbox.java.guice4.servlet.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.StreamingOutput;

@Singleton
@Path("/stream")
public class RestStreaming {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response stream(){
		return Response.ok( new StreamingOutput() {
			@Override
			public void write(OutputStream output) throws IOException, WebApplicationException {
				while(true){
					output.write(new Date().toString().getBytes());
					output.flush();
				}
			}
		}).status(Status.OK).build();
	}
}	
