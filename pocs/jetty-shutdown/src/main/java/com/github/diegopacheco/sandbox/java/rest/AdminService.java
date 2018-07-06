package com.github.diegopacheco.sandbox.java.rest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.diegopacheco.sandbox.java.jetty.JettyServerRunner;

@Path("/admin")
public class AdminService {

	private static final ScheduledExecutorService es = Executors.newScheduledThreadPool(1);

	@GET
	@Path("/shutdown/")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String shutwdown() {
		es.schedule(new Runnable() {
			@Override
			public void run() {
				try {
					JettyServerRunner.getSever().stop();
					JettyServerRunner.getSever().join();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					System.exit(0);
				}
			}
		},5,TimeUnit.SECONDS);
		return "OK - Shutdown in 5s";
	}

}
