package com.blogspot.diegopacheco.jms.activemq.blob.jetty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

/**
 * 
 * @author Diego Pacheco
 *
 */
public class JettyServer {
	public static void main(String[] args) throws Throwable {

		Server server = new Server(9089);
		Context root = new Context(server,"/",Context.SESSIONS);
		
		root.addServlet(new ServletHolder(new HttpServlet() {
			private static final long serialVersionUID = 1L;
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,	IOException {
				resp.getOutputStream().print("<b>Welcome Folks!</b> to Diego Pacheco *Jetty Rocks* Server :D");
			}
		}), "/");
		
		root.addServlet(new ServletHolder(new PDFDownloadServlet()), "/download/pdf");
		root.addServlet(new ServletHolder(new PDFUploadServlet()), "/upload/pdf/*");
		
		server.start();
		
	}
}


