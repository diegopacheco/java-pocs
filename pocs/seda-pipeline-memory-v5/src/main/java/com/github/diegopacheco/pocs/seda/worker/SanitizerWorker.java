package com.github.diegopacheco.pocs.seda.worker;

import com.github.diegopacheco.pocs.seda.ff.FeatureFlagManager;
import com.github.diegopacheco.pocs.seda.metrics.MetricsManager;
import com.github.diegopacheco.pocs.seda.seda.SEDAManager;
import com.github.diegopacheco.pocs.seda.seda.Queues;
import com.github.diegopacheco.pocs.seda.thread.SilentThread;

public class SanitizerWorker implements Worker {

    private SEDAManager sedaManager;
    private Queues next;

    private String event;

    public SanitizerWorker(SEDAManager queueManager, Queues next, String event) {
        this.sedaManager = queueManager;
        this.next = next;
        this.event = event;
    }

    @Override
    public void run() {
        if (null != event) {
            try {
                String sanitizedEvent = sanitize(event);
                sedaManager.publish(next, sanitizedEvent);

                MetricsManager.ok(Queues.SANITIZER_QUEUE.name());
            } catch (Exception e) {
                MetricsManager.error(Queues.SANITIZER_QUEUE.name());
            }
        }
        System.out.println("Worker[" + this.getClass().getSimpleName() +
                "~" + Thread.currentThread().getName() +
                "] completed. ");
    }

    private String sanitize(String event) {
        SilentThread.sleep(FeatureFlagManager.get(FeatureFlagManager.QUEUE_SANITIZER_TIME_BACKPRESSURE_MS));
        return event.trim().toLowerCase();
    }

}
