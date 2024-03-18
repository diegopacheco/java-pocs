package com.github.diegopacheco.pocs.seda.worker;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class DynamicBaseWorker implements Worker{

    private final AtomicBoolean running = new AtomicBoolean(true);

    @Override
    public void drain() {
        System.out.println("Draining... ");
        if (running.get()){
            System.out.println("Worker[" + this.getClass().getSimpleName() +
                    "~" + Thread.currentThread().getName() +
                    "] is busy - finishing current. ");
            running.set(false);
        }
    }

    @Override
    public void resume() {
        System.out.println("Resuming... ");
        if (!running.get()){
            System.out.println("Worker[" + this.getClass().getSimpleName() +
                    "~" + Thread.currentThread().getName() +
                    "] was sleepy - back to work... ");
            running.set(true);
        }
    }

    protected boolean isRunning(){
        return running.get();
    }
}
