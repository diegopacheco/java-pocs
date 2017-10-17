package com.github.diegopacheco.sandbox.java.netflixoss.servo.poc.metrics;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.netflix.servo.publish.AsyncMetricObserver;
import com.netflix.servo.publish.BasicMetricFilter;
import com.netflix.servo.publish.CounterToRateMetricTransform;
import com.netflix.servo.publish.FileMetricObserver;
import com.netflix.servo.publish.JvmMetricPoller;
import com.netflix.servo.publish.MetricObserver;
import com.netflix.servo.publish.MetricPoller;
import com.netflix.servo.publish.MonitorRegistryMetricPoller;
import com.netflix.servo.publish.PollRunnable;
import com.netflix.servo.publish.PollScheduler;
import com.netflix.servo.publish.graphite.GraphiteMetricObserver;
import com.sun.net.httpserver.HttpServer;

public final class ServoMain {

    private ServoMain() {}

    private static MetricObserver rateTransform(MetricObserver observer) {
        final long heartbeat = 2 * Config.getPollInterval();
        return new CounterToRateMetricTransform(observer, heartbeat, TimeUnit.SECONDS);
    }

    private static MetricObserver async(String name, MetricObserver observer) {
        final long expireTime = 2000 * Config.getPollInterval();
        final int queueSize = 10;
        return new AsyncMetricObserver(name, observer, queueSize, expireTime);
    }

    private static MetricObserver createFileObserver() {
        final File dir = Config.getFileObserverDirectory();
        return rateTransform(new FileMetricObserver("servo-example", dir));
    }

    private static MetricObserver createGraphiteObserver() {
        final String prefix = Config.getGraphiteObserverPrefix();
        final String addr = Config.getGraphiteObserverAddress();
        return rateTransform(async("graphite", new GraphiteMetricObserver(prefix, addr)));
    }

    private static void schedule(MetricPoller poller, List<MetricObserver> observers) {
        final PollRunnable task = new PollRunnable(poller, BasicMetricFilter.MATCH_ALL,true, observers);
        PollScheduler.getInstance().addPoller(task, Config.getPollInterval(), TimeUnit.SECONDS);
    }

    private static void initMetricsPublishing() throws Exception {
        final List<MetricObserver> observers = new ArrayList<MetricObserver>();
        if (Config.isFileObserverEnabled()) {
            observers.add(createFileObserver());
        }
        if (Config.isGraphiteObserverEnabled()) {
            observers.add(createGraphiteObserver());
        }

        PollScheduler.getInstance().start();
        schedule(new MonitorRegistryMetricPoller(), observers);

        if (Config.isJvmPollerEnabled()) {
            schedule(new JvmMetricPoller(), observers);
        }
    }
    
    private static void initHttpServer() throws Exception {
        // Setup default endpoints
        final HttpServer server = HttpServer.create();
        server.createContext("/echo", new EchoHandler());

        // Hook to allow for graceful exit
        final Closeable c = new Closeable() {
            public void close() throws IOException {
                PollScheduler.getInstance().stop();
                server.stop(5);
            }
        };
        server.createContext("/exit", new ExitHandler(c));

        // Bind and start server
        server.bind(new InetSocketAddress(Config.getPort()), 0);
        server.start();
    }
    
    //
    // To test: $ curl --data "servo ping" http://localhost:8090/echo
    //
    public static void main(String[] args) throws Exception {
    	System.setProperty("servo.pollers", "5000");
        initMetricsPublishing();
        initHttpServer();
    }
}