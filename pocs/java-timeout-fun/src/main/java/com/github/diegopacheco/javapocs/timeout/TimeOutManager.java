package com.github.diegopacheco.javapocs.timeout;

import java.time.Duration;
import java.util.concurrent.*;

public class TimeOutManager {

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    public static <T> T executeWithTimeout(int timeoutInMS,Callable<T> codeBlock){

        final Duration timeout = Duration.ofMillis(timeoutInMS);

        final Future<T> handler = executor.submit(new Callable() {
            @Override
            public T call() throws Exception {
                return codeBlock.call();
            }
        });

        try{
            return handler.get(timeout.toMillis(), TimeUnit.MILLISECONDS);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void shutdown(){
        executor.shutdown();
    }

}
