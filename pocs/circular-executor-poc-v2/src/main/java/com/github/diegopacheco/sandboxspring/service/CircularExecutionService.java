package com.github.diegopacheco.sandboxspring.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Careful with this class, every instance will create a thread pool of 1 thread.
 */
@Service
public class CircularExecutionService {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public Boolean work(){
        final Callable<Boolean> task = ()->{
            silentSleep(2000);
            // 10% chance of success
            if (Math.random() < 0.10) {
                return true;
            } else {
                return false;
            }
        };
        WorkTraker wt = new WorkTraker(task);
        doWork(wt);
        return true;
    }

    private void doWork(WorkTraker wt){
        Runnable taskManager = ()->{
            boolean result = false;
            try {
                System.out.println(">>> Running Expensive Computation. Attempt: [" + wt.getAttempts() + "]");
                result = wt.getTask().call();
            } catch (Exception e) {
                System.out.println(">>> Exception: " + e.getMessage() + " !!! Lets Retry");
                doWork(WorkTraker.from(wt));
            }
            if (!result) {
                System.out.println(">>> Failure! Lets Retry");
                doWork(WorkTraker.from(wt));
            } else{
                System.out.println(">>> Success!");
            }
        };
        executor.submit(taskManager);
    }

    private void silentSleep(int timeInMS){
        try {
            Thread.sleep(timeInMS);
        } catch (InterruptedException e) {}
    }

}
