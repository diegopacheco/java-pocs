package com.github.diegopacheco.pocs.seda.worker;

import com.github.diegopacheco.pocs.seda.event.Event;
import com.github.diegopacheco.pocs.seda.ff.FeatureFlagManager;
import com.github.diegopacheco.pocs.seda.metrics.MetricsManager;
import com.github.diegopacheco.pocs.seda.seda.Queues;
import com.github.diegopacheco.pocs.seda.thread.SilentThread;

import java.util.Date;

public class ConsoleWorker implements Worker {

    private Event<String> event;

    public ConsoleWorker(Event<String> event) {
        this.event = event;
    }

    @Override
    public void run() {
        if (null != event) {
            try {
                event.addStage("CONSOLE");
                SilentThread.sleep(FeatureFlagManager.get(FeatureFlagManager.QUEUE_CONSOLE_TIME_BACKPRESSURE_MS));
                System.out.println(new Date() + " - event finish pipeline.");
                System.out.println(event);

                MetricsManager.ok(Queues.CONOSLE_QUEUE.name());
            } catch (Exception e) {
                MetricsManager.error(Queues.CONOSLE_QUEUE.name());
            }
            System.out.println("Worker[" + this.getClass().getSimpleName() +
                    "~" + Thread.currentThread().getName() +
                    "] completed. ");
        }
    }
}