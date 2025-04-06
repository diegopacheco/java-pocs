package com.github.diegopacheco.poison.pill.pattern;

import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable {
    private final BlockingQueue<Message> queue;

    public Worker(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message msg = queue.take();
                if (msg instanceof PoisonPill) {
                    System.out.println(Thread.currentThread().getName() + " received Poison Pill, stopping.");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " processing message: " + msg.getContent());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
