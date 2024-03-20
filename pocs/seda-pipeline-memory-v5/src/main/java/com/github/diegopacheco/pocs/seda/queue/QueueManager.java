package com.github.diegopacheco.pocs.seda.queue;

import com.github.diegopacheco.pocs.seda.worker.CatWorker;
import com.github.diegopacheco.pocs.seda.worker.ConsoleWorker;
import com.github.diegopacheco.pocs.seda.worker.SanitizerWorker;
import com.github.diegopacheco.pocs.seda.worker.Worker;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueManager<T> {

    private static final Integer TOTAL_THREADS_PER_WORKER = 3;

    private static ExecutorService poolSanitizer = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER);
    private static ExecutorService poolCat = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER);
    private static ExecutorService poolConsole = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER);

    private LinkedBlockingDeque<T> queue = new LinkedBlockingDeque<>();
    private String name;

    public QueueManager(String name){
        this.name = name;
    }

    public QueueManager(Queue<T> queue,String name) {
        this.queue =(LinkedBlockingDeque)queue;
        this.name = name;
    }

    public boolean publish(Queues queue,T event){
        if (null!=event){
            switch (queue){
                case SANITIZER_QUEUE -> poolSanitizer.submit(null);
                case CAT_QUEUE -> poolCat.submit(null);
                case CONOSLE_QUEUE -> poolConsole.submit(null);
            }
            return true;
        }
        return false;
    }

    private Worker newSanitizerWorker(String event){
        return new SanitizerWorker((QueueManager<String>)this,Queues.CAT_QUEUE,event);
    }

    private Worker newCatWorker(String event){
        return new CatWorker((QueueManager<String>)this,Queues.CONOSLE_QUEUE,event);
    }

    private Worker newConsoleWorker(String event){
        return new ConsoleWorker(event);
    }

    public String getName() {
        return name;
    }

}
