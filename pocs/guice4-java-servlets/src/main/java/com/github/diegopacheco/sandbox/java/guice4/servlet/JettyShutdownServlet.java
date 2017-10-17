package com.github.diegopacheco.sandbox.java.guice4.servlet;

import java.io.IOException;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;

@Singleton
public class JettyShutdownServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Server server;
	
	public JettyShutdownServlet(Server server) {
		this.server = server;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			server.stop();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}