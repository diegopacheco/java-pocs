package com.github.diegopacheco.javapocs.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName="counterFilter")
public class Counter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("There we go");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println("HIT : " + httpRequest.getContextPath() + " - " +
                                      httpRequest.getRequestURI());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("done.");
    }
}
