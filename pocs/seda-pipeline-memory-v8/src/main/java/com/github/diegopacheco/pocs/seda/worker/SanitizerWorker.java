package com.github.diegopacheco.pocs.seda.worker;

import com.github.diegopacheco.pocs.seda.event.Event;
import com.github.diegopacheco.pocs.seda.ff.FeatureFlagManager;
import com.github.diegopacheco.pocs.seda.metrics.MetricsManager;
import com.github.diegopacheco.pocs.seda.seda.SEDAManager;
import com.github.diegopacheco.pocs.seda.seda.Queues;
import com.github.diegopacheco.pocs.seda.thread.SilentThread;

public class SanitizerWorker implements Worker {

    private WorkerContext context;
    public SanitizerWorker(WorkerContext context) {
        this.context = context;
    }

    @Override
    public void run() {
        if (null != context.getEvent()) {
            try {
                Event<String> sanitizedEvent = sanitize(context.getEvent());
                System.out.println(" >> " + sanitizedEvent);
                context.getSedaManager().publish(context.getNext(), sanitizedEvent);

                MetricsManager.ok(Queues.SANITIZER_QUEUE.name());
            } catch (Exception e) {
                MetricsManager.error(Queues.SANITIZER_QUEUE.name());
            }
            context.getCompletionHandler().signalDone();
        }
        System.out.println("Worker[" + this.getClass().getSimpleName() +
                "~" + Thread.currentThread().getName() +
                "] completed. ");
    }

    @Override
    public Event<?> getEvent() {
        return context.getEvent();
    }

    private Event<String> sanitize(Event<String> event) {
        SilentThread.sleep(FeatureFlagManager.get(FeatureFlagManager.QUEUE_SANITIZER_TIME_BACKPRESSURE_MS));
        return new Event(event.getContent().trim().toLowerCase()).addStage("SANITIZER");
    }

}
