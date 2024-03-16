package com.github.diegopacheco.pocs.seda.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueManager<T> {

    private Queue<T> queue = new ConcurrentLinkedQueue<>();

    public QueueManager(){}

    public QueueManager(Queue<T> queue) {
        this.queue = queue;
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

}
