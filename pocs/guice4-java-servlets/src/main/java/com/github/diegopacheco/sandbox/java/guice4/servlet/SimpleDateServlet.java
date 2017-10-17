package com.github.diegopacheco.sandbox.java.guice4.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.diegopacheco.sandbox.java.guice4.servlet.service.DateService;
import com.google.inject.Singleton;

@Singleton
public class SimpleDateServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	private DateService service;
	
    @Inject
    public SimpleDateServlet(DateService ds) {
    	this.service = ds;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.getWriter().write(service.getDate());
    	response.flushBuffer();
    }
}