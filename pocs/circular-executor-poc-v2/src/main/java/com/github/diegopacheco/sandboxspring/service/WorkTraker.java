package com.github.diegopacheco.sandboxspring.service;

import java.util.concurrent.Callable;

public class WorkTraker {

    private Long timestamp = System.currentTimeMillis();
    private Integer attempts = 0;
    private Callable<Boolean> task = null;

    public WorkTraker(Callable<Boolean> task){
        this.task = task;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public Callable<Boolean> getTask() {
        return task;
    }

    public static WorkTraker from(WorkTraker workTraker){
        WorkTraker workTrakerNew = new WorkTraker(
                workTraker.getTask());
                workTrakerNew.attempts = workTraker.getAttempts() + 1;
                workTrakerNew.timestamp = workTraker.getTimestamp();
        return workTrakerNew;
    }
}
