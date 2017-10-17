package com.github.diegopacheco.sandbox.java.guice4.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.diegopacheco.sandbox.java.guice4.servlet.service.CalcService;

@Singleton
public class CalcServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	private CalcService service;
	
    @Inject
    public CalcServlet(CalcService cs) {
    	this.service = cs;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Double a = new Double(request.getParameter("a").toString());
    	Double b = new Double(request.getParameter("b").toString());
    	response.getWriter().write(service.sum(a,b) + "");
    	response.flushBuffer();
    }
}