package com.github.diegopacheco.pocs.seda.worker;

import com.github.diegopacheco.pocs.seda.queue.QueueManager;

public class SanitizerWorker implements Worker {

    private QueueManager<String> inQueue;
    private QueueManager<String> outQueue;

    public SanitizerWorker(QueueManager<String> inQueue, QueueManager<String> outQueue) {
        this.inQueue = inQueue;
        this.outQueue = outQueue;
    }

    @Override
    public void run() {
        while(true){
            String event = inQueue.consume();
            if (null!=event){
                String sanitized = sanitize(event);
                outQueue.publish(sanitized);
            }
        }
    }

    private String sanitize(String event) {
        return event.trim().toLowerCase();
    }

}
