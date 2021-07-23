package com.github.diegopacheco.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class InfiniteCounter {

    private static InfiniteCounter INSTANCE;
    private static AtomicInteger counter = new AtomicInteger(0);

    private InfiniteCounter(){}

    public static InfiniteCounter getInstance(){
        if (null==INSTANCE){
            synchronized (InfiniteCounter.class){
                if (null==INSTANCE){
                    INSTANCE=new InfiniteCounter();
                }
            }
        }
        return INSTANCE;
    }

    public int inc(){
        if (Integer.MAX_VALUE <= get()){
            System.out.println("Resetting counter!");
            counter = new AtomicInteger(0);
        }
        return counter.incrementAndGet();
    }

    public int get(){
        return counter.get();
    }

}
