package com.github.diegopacheco.pocs.seda.thread;

public class SilentThread {

    public static void sleep(int timeSeconds){
        try {
            // Simulate some DB call or work that take same time.
            Thread.sleep(timeSeconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void join(Thread t){
        try {
            t.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
