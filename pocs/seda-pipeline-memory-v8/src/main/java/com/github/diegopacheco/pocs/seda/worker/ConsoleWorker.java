package com.github.diegopacheco.pocs.seda.worker;

import com.github.diegopacheco.pocs.seda.event.Event;
import com.github.diegopacheco.pocs.seda.ff.FeatureFlagManager;
import com.github.diegopacheco.pocs.seda.metrics.MetricsManager;
import com.github.diegopacheco.pocs.seda.seda.Queues;
import com.github.diegopacheco.pocs.seda.thread.SilentThread;

import java.util.Date;

public class ConsoleWorker implements Worker {

    private WorkerContext context;

    public ConsoleWorker(WorkerContext context) {
        this.context = context;
    }

    @Override
    public void run() {
        if (null != context.getEvent()) {
            try {
                context.getEvent().addStage("CONSOLE");
                SilentThread.sleep(FeatureFlagManager.get(FeatureFlagManager.QUEUE_CONSOLE_TIME_BACKPRESSURE_MS));
                System.out.println(new Date() + " - event finish pipeline.");
                System.out.println(" >> " + context.getEvent());

                MetricsManager.ok(Queues.CONSOLE_QUEUE.name());
            } catch (Exception e) {
                MetricsManager.error(Queues.CONSOLE_QUEUE.name());
            }
            context.getCompletionHandler().signalDone();
            System.out.println("Worker[" + this.getClass().getSimpleName() +
                    "~" + Thread.currentThread().getName() +
                    "] completed. ");
        }
    }

    @Override
    public Event<?> getEvent() {
        return context.getEvent();
    }
}