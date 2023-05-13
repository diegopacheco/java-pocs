package com.github.diegopacheco.javapocs.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@WebFilter(filterName="counterFilter")
public class Counter implements Filter {

    private Queue<HitEvent> queue = new ConcurrentLinkedQueue<HitEvent>();
    private ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        int duration = 5;
        System.out.println("There we go - running every " + duration + " seconds");

        // run every 5 secs - but could be longer, ideally different times for prod vs non-prod
        // bigger time, more performance but might lose data if apps crash, lower time less performance but dont loose records.
        // i.e 1 mim non prod, 5 mim prod.
        pool.scheduleAtFixedRate(loggerTask, 3,duration, TimeUnit.SECONDS);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        publish(httpRequest.getRequestURI());
        chain.doFilter(request, response);
    }

    private void publish(String path){
        HitEvent event = new HitEvent(path,System.currentTimeMillis());
        queue.add(event);
    }

    // Could be storing on DB, Centralized Log, whatever...
    private Runnable loggerTask = () -> {
        HitEvent event = queue.poll();
        System.out.println("Executing Task At " + System.nanoTime());
        while (null!=event){
            System.out.println("Got event: " + event);
            event = queue.poll();
        }
    };

    @Override
    public void destroy() {
        System.out.println("done.");
    }
}
