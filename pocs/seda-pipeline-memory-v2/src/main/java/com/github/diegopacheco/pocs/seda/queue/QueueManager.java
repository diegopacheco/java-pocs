package com.github.diegopacheco.pocs.seda.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueManager<T> {

    private Queue<T> queue = new ConcurrentLinkedQueue<>();
    private String name;

    public QueueManager(String name){
        this.name = name;
    }

    public QueueManager(Queue<T> queue,String name) {
        this.queue = queue;
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
            return queue.poll();
        }
        return null;
    }

    public String getName() {
        return name;
    }

}
