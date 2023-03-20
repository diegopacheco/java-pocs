package com.github.diegopacheco.j19.vthreads.fun;

import java.time.Duration;

public class Main {
    public static void main(String args[]) {
        concurrentMorningRoutine();
    }

    static void concurrentMorningRoutine() {
        try{
            var bathTime = bathTime();
            var boilingWater = boilingWater();
            bathTime.join();
            boilingWater.join();
        }catch(Exception e){}
    }

    static Thread boilingWater() {
        return virtualThread(
                "Boil some water",
                () -> {
                    log("I'm going to boil some water");
                    sleep(Duration.ofSeconds(1L));
                    log("I'm done with the water");
                });
    }

    static Thread bathTime() {
        return virtualThread(
                "Bath time",
                () -> {
                    log("I'm going to take a bath");
                    sleep(Duration.ofMillis(500L));
                    log("I'm done with the bath");
                });
    }

    private static Thread virtualThread(String name, Runnable runnable) {
        return Thread.ofVirtual()
                .name(name)
                .start(runnable);
    }

    private static void sleep(Duration duration) {
        try{
            Thread.sleep(duration);
        }catch(Exception e){}
    }

    static void log(String message) {
        System.out.println(message + " - " + Thread.currentThread());
    }
}
