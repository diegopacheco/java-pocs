package com.github.diegopacheco.sandboxspring.service;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.Callable;

public class WorkTask implements Callable<Object> {

    private long enterTheQueueTS;
    private int attempts;
    private boolean isSuccess;
    private Object result;

    public WorkTask(){}

    public WorkTask(long enterTheQueueTS, int attempts, boolean isSuccess, Map<String, String> result) {
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
        System.out.println("calling some bad service takes time to be successful");
        Thread.sleep(3000);

        isSuccess = Math.random() < 0.01;
        System.out.println("isSuccess: " + isSuccess);
        if (isSuccess){
            return new Date();
        } else{
            return null;
        }
    }
}
