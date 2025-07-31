package com.github.diegopacheco.sandboxspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Service
public class CircularServiceCaller {

    @Autowired
    private ExecutorService ex;

    public CircularServiceCaller(ExecutorService ex){
        this.ex = ex;
    }

    public boolean enqueueWork(WorkTask task){
        CompletableFuture.supplyAsync(() -> {
            try {
                return ex.submit(task).get();
            } catch (Exception e) {
                return null;
            }
        }, ex).thenAccept(result -> {
            WorkTask wt = (WorkTask)result;
            if (wt.getResult()==null) {
                System.out.println("> Not done yet, so we will add to the queue and try again...");
                enqueueWork(task);
            } else{
                System.out.println("> Done! Result: " + wt.getResult());
            }
        });
        return true;
    }

}
