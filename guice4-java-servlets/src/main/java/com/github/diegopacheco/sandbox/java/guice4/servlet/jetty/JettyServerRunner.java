package com.github.diegopacheco.sandbox.java.guice4.servlet.jetty;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Slf4jRequestLog;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import com.github.diegopacheco.sandbox.java.guice4.servlet.JettyShutdownServlet;
import com.github.diegopacheco.sandbox.java.guice4.servlet.module.ApplicationServletModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

public class JettyServerRunner {

	private Injector injector;
	private Server server;
	
	private static JettyServerRunner instance;
	
	public static JettyServerRunner getInstance(){
		if(instance==null)
			instance = new JettyServerRunner();
		return instance;
	}
	
	public void run(){
		try{
			ApplicationServletModule applicationServletModule = new ApplicationServletModule();
			Injector injector = Guice.createInjector(applicationServletModule);
			this.injector = injector;
					
			int port = 8090;
			Server server = new Server(port);

			ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
			servletContextHandler.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
			servletContextHandler.addServlet(DefaultServlet.class, "/");
			
			servletContextHandler.addServlet(new ServletHolder(new JettyShutdownServlet(server)), "/shutdown");
			
			ResourceConfig config = new ResourceConfig();
			config.packages("com.github.diegopacheco.sandbox.java.guice4.servlet.rest");
			ServletHolder servlet = new ServletHolder(new ServletContainer(config));
			servletContextHandler.addServlet(servlet, "/*");
			
			servletContextHandler.addServlet(new ServletHolder(new HystrixMetricsStreamServlet()), "/hystrix.strteam");
			
		    HandlerCollection collection = new HandlerCollection();
		    RequestLogHandler rlh = new RequestLogHandler();
		    Slf4jRequestLog requestLog = new Slf4jRequestLog();
		    requestLog.setExtended(false);
		    rlh.setRequestLog(requestLog);
		    collection.setHandlers(new Handler[] { servletContextHandler, rlh });
		    server.setHandler(collection);
		    
		    this.server = server;
		    
			server.start();
			server.join();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public Injector getInjector() {
		return injector;
	}

	public Server getServer() {
		return server;
	}

	public static void main(String[] args){
		JettyServerRunner.getInstance().run();
	}

}
