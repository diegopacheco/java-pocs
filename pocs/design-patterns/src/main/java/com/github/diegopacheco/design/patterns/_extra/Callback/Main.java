package com.github.diegopacheco.design.patterns._extra.Callback;

public class Main {
    public static void main(String[] args) {
        StopWatch sw = StopWatch
                .withCallback((diff)-> System.out.println("Diff this is " + diff + " ms"))
                .start();
        sleep();
        sw.stop();
    }
    private static void sleep(){
        try{
            Thread.sleep(2000L);
        }catch(Exception e){}
    }
}
