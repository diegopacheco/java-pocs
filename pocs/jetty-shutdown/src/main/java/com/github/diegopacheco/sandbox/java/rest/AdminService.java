package com.github.diegopacheco.sandbox.java.rest;

import javax.ws.rs.Path;

import com.github.diegopacheco.sandbox.java.jetty.JettyServerRunner;

@Path("admin")
public class AdminService {

	@Path("/shutdown")
	public String shutwdown() {
		try {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						JettyServerRunner.getSever().stop();
						JettyServerRunner.getSever().join();
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.exit(0);
				}
			}).start();
			return "OK";
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
