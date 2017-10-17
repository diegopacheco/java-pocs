package com.github.diegopacheco.sandbox.java.netflixoss.servo.poc.metrics;

import java.io.File;

import com.netflix.servo.monitor.Pollers;

public final class Config {
    
	private Config() {}

    public static int getPort() {
        return Integer.parseInt(System.getProperty("servo.example.port", "8090"));
    }

    /**
     * How frequently to poll metrics in seconds and report to observers.
     */
    public static long getPollInterval() {
        return Pollers.getPollingIntervals().get(0) / 1000L;
    }

    /**
     * Should we report metrics to the file observer? Default is true.
     */
    public static boolean isFileObserverEnabled() {
        return Boolean.valueOf(System.getProperty("servo.example.isFileObserverEnabled", "true"));
    }

    /**
     * Default directory for writing metrics files. Default is /tmp.
     */
    public static File getFileObserverDirectory() {
        return new File(System.getProperty("servo.example.fileObserverDirectory", "D:/tmp/"));
    }

    /**
     * Should we report metrics to graphite? Default is false.
     */
    public static boolean isGraphiteObserverEnabled() {
        return Boolean.valueOf(System.getProperty("servo.example.isGraphiteObserverEnabled","false"));
    }

    /**
     * Prefix to use when reporting data to graphite. Default is servo.
     */
    public static String getGraphiteObserverPrefix() {
        return System.getProperty("servo.example.graphiteObserverPrefix", "servo");
    }

    /**
     * Address for reporting to graphite. Default is localhost:2003.
     */
    public static String getGraphiteObserverAddress() {
        return System.getProperty("servo.example.graphiteObserverAddress", "localhost:2003");
    }

    /**
     * Should we poll the standard jvm mbeans? Default is true.
     */
    public static boolean isJvmPollerEnabled() {
        return Boolean.valueOf(System.getProperty("servo.example.isJvmPollerEnabled", "true"));
    }
}