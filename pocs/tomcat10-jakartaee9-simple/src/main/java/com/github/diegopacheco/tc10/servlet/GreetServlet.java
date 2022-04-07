package com.github.diegopacheco.tc10.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/greet")
public class GreetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

        var out = resp.getOutputStream();
        out.println("This is a Jakarta EE 9 Servlet!");
        out.println();
        out.println("this.getServletContext().getServerInfo() = " + this.getServletContext().getServerInfo());
        out.println("this.getClass().getSuperclass() = " + this.getClass().getSuperclass());
        out.println("System.getProperty(\"java.version\") = " + System.getProperty("java.version"));
        out.println("System.getProperty(\"java.runtime.version\") = " + System.getProperty("java.runtime.version"));
        out.println("System.getProperty(\"java.vendor\") = " + System.getProperty("java.vendor"));
    }

}