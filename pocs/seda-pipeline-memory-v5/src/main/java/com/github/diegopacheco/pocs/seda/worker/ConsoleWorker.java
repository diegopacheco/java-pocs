package com.github.diegopacheco.pocs.seda.worker;

import com.github.diegopacheco.pocs.seda.ff.FeatureFlagManager;
import com.github.diegopacheco.pocs.seda.metrics.MetricsManager;
import com.github.diegopacheco.pocs.seda.queue.Queues;
import com.github.diegopacheco.pocs.seda.thread.SilentThread;

import java.util.Date;

public class ConsoleWorker extends DynamicBaseWorker implements Worker {

    private String event;

    public ConsoleWorker(String event) {
        this.event = event;
    }

    @Override
    public void run() {
        if (isRunning()) {
            if (null != event) {
                try {
                    SilentThread.sleep(FeatureFlagManager.get(FeatureFlagManager.QUEUE_CONSOLE_TIME_BACKPRESSURE_MS));
                    System.out.println(new Date() + " - event finish pipeline.");
                    System.out.println(event);

                    MetricsManager.ok(Queues.CONOSLE_QUEUE.name());
                } catch (Exception e) {
                    MetricsManager.error(Queues.CONOSLE_QUEUE.name());
                }
            }
            System.out.println("Worker[" + this.getClass().getSimpleName() +
                    "~" + Thread.currentThread().getName() +
                    "] completed. ");
        }
    }
}