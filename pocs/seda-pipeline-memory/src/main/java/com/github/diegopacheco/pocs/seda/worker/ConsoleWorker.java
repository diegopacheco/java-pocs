package com.github.diegopacheco.pocs.seda.worker;

import com.github.diegopacheco.pocs.seda.queue.QueueManager;

import java.util.Date;

public class ConsoleWorker implements Worker {

    private QueueManager<String> inQueue;

    public ConsoleWorker(QueueManager<String> inQueue) {
        this.inQueue = inQueue;
    }

    @Override
    public void run() {
        while (true) {
            String event = inQueue.consume();
            if (null != event) {
                System.out.println(new Date() + " - event finish pipeline.");
                System.out.println(event);
            }
        }
    }
}
