package com.github.diegopacheco.sandbox.java.cass.dual.writer.rest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyServer {
	public static void main(String[] args) {
			
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");

    Server jettyServer = new Server(8080);
    jettyServer.setHandler(context);

    ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
    jerseyServlet.setInitOrder(0);
    jerseyServlet.setInitParameter("jersey.config.server.provider.classnames",EntryPoint.class.getCanonicalName());
    
    /* Register Jackson as JSON provider */
    jerseyServlet.setInitParameter("jersey.config.server.provider.packages", "com.fasterxml.jackson.jaxrs.json"); 
    
    try {
    	  System.out.println("Jetty Server running on http://127.0.0.1:8080 "); 
        jettyServer.start();
        jettyServer.join();
    } catch (Exception e) {
			e.printStackTrace();
		} finally {
      jettyServer.destroy();
    }	
    
	}
		
}
