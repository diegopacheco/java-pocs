package com.github.diegopacheco.sandbox.java.jetty;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ShutdownHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class JettyServerRunner {
	
	private static JettyServerRunner instance;
	private static Server server;
	
	private JettyServerRunner() {}
	
	public static synchronized JettyServerRunner getInstance() {
		if (instance==null) {
			instance = new JettyServerRunner();
		}
		return instance;
	}
	
	public static synchronized Server getSever() {
		getInstance();
		return server;
	}
	
	private synchronized void run() {
		try {
			ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
			context.setContextPath("/");
			ServletHolder sh = context.addServlet(ServletContainer.class, "/*");
			sh.setInitOrder(1);
			sh.setInitParameter("jersey.config.server.provider.packages", "com.github.diegopacheco.sandbox.java.rest");
			
			ShutdownHandler shutdown = new ShutdownHandler("now");
			shutdown.setExitJvm(false);
			shutdown.setSendShutdownAtStart(true);
			
	    Server server = new Server(8080);
	    HandlerList handlers = new HandlerList();
	    handlers.setHandlers(new Handler[]
	    { context, shutdown });
	    server.setHandler(handlers);
	    server.setStopAtShutdown(true);
	    shutdown.setServer(server);
	    server.start();
			
			System.out.println("Jetty Server 9.4 running on: http://localhost:8080/");
			System.out.println("You can do: ");
			System.out.println("-- http://localhost:8080/date");
			System.out.println("-- http://localhost:8080/admin/shutdown");
			JettyServerRunner.server = server;
			server.join();
			
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
	
	public static void main(String[] args) {
		 JettyServerRunner.getInstance().run();
	}
}
