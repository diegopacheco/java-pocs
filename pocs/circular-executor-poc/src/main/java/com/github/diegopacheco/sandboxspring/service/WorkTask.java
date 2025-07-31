package com.github.diegopacheco.sandboxspring.service;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class WorkTask implements Callable<Object> {

    private long enterTheQueueTS = System.currentTimeMillis();
    private int attempts;
    private boolean isSuccess;
    private Object result;
    private ExecutorService ex;

    public WorkTask(){}

    public WorkTask(ExecutorService ex) {
        this.ex = ex;
    }

    public WorkTask(long enterTheQueueTS, int attempts, boolean isSuccess, Object result) {
        this.enterTheQueueTS = enterTheQueueTS;
        this.attempts = attempts;
        this.isSuccess = isSuccess;
        this.result = result;
    }

    public long getEnterTheQueueTS() {
        return enterTheQueueTS;
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public Object getResult() {
        return result;
    }

    @Override
    public Object call() throws Exception {
        String threadName = Thread.currentThread().getName();
        String header = ">>> " + threadName + " attempts: " + attempts;

        System.out.println(header + " calling some bad service takes time to be successful");
        Thread.sleep(3000);

        // 10% chance of success
        isSuccess = Math.random() < 0.10;
        System.out.println(header + " isSuccess? " + isSuccess);
        if (isSuccess){
            result = new Date();
        } else {
            attempts++;
        }
        printExecutorStats(ex);
        return this;
    }

    private void printExecutorStats(ExecutorService ex) {
        if (ex instanceof ThreadPoolExecutor) {
            ThreadPoolExecutor tpe = (ThreadPoolExecutor) ex;
            System.out.println(">>> Metrics - Active tasks: " + tpe.getActiveCount());
            System.out.println(">>> Metrics - Queue size: " + tpe.getQueue().size());
        }
    }
}
