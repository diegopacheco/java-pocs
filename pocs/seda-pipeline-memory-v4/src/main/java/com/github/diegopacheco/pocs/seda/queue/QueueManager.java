package com.github.diegopacheco.pocs.seda.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueManager<T> {

    private LinkedBlockingDeque<T> queue = new LinkedBlockingDeque<>();
    private String name;

    public QueueManager(String name){
        this.name = name;
    }

    public QueueManager(Queue<T> queue,String name) {
        this.queue =(LinkedBlockingDeque)queue;
        this.name = name;
    }

    public boolean publish(T event){
        if (null!=event){
            queue.add(event);
            return true;
        }
        return false;
    }

    public T consume(){
        if (!queue.isEmpty()){
            try {
                return queue.take();
            } catch (Exception e) {
                System.out.println("Error consuming queue - " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

}
