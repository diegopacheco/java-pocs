package com.github.diegopacheco.sandbox.java.parseq;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import com.linkedin.parseq.batching.BatchingSupport;
import com.linkedin.parseq.Engine;
import com.linkedin.parseq.EngineBuilder;
import com.linkedin.parseq.Task;
import com.linkedin.parseq.httpclient.HttpClient;
import com.ning.http.client.Response;

public class ParseqMain {

    private final static BatchingSupport _batchingSupport = new BatchingSupport();

    public static void main(String[] args) throws Exception{
        final int numCores = Runtime.getRuntime().availableProcessors();
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(numCores + 1);
        final EngineBuilder builder = new EngineBuilder().setTaskExecutor(scheduler).setTimerScheduler(scheduler);
        builder.setPlanDeactivationListener(_batchingSupport);
        final Engine engine = builder.build();
        final Task<Response> google = HttpClient.get("http://www.google.com").task();
        engine.run(google);
        google.await();
        System.out.println("Google Page: " + google.get().getResponseBody());    
    }
}
