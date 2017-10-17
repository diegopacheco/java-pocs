package com.github.diegopacheco.sandbox.java.guice4.servlet.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.diegopacheco.sandbox.java.guice4.servlet.hystrix.GenericCommand;

@Singleton
@Path("/safe")
public class SafeResourceWithHystrix {
	
	@GET
	@Path("ok")
	@Produces(MediaType.TEXT_PLAIN)
	public Response ok(){
		String result = new GenericCommand("ok-cmd"){
			@Override
			protected String run() {
				return "OK";
			}
		}.execute();
		return Response.ok(result).build(); 
	}
	
	@GET
	@Path("ko")
	@Produces(MediaType.TEXT_PLAIN)
	public Response ko(){
		String result = new GenericCommand("ko-cmd"){
			@Override
			protected String run() {
				throw new RuntimeException("Error by Design!");
			}
		}.execute();
		return Response.ok(result).build(); 
	}
	
	@GET
	@Path("slow")
	@Produces(MediaType.TEXT_PLAIN)
	public Response slow(){
		String result = new GenericCommand("slow-cmd"){
			@Override
			protected String run() {
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return "SLOW";
			}
		}.execute();
		return Response.ok( result ).build(); 
	}
	
}
