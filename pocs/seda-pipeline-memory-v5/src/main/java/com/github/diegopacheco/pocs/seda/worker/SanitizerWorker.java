package com.github.diegopacheco.pocs.seda.worker;

import com.github.diegopacheco.pocs.seda.ff.FeatureFlagManager;
import com.github.diegopacheco.pocs.seda.metrics.MetricsManager;
import com.github.diegopacheco.pocs.seda.queue.QueueManager;
import com.github.diegopacheco.pocs.seda.queue.Queues;
import com.github.diegopacheco.pocs.seda.thread.SilentThread;

public class SanitizerWorker extends DynamicBaseWorker implements Worker {

    private QueueManager<String> queueManager;
    private Queues next;

    private String event;

    public SanitizerWorker(QueueManager<String> queueManager, Queues next,String event) {
        this.queueManager = queueManager;
        this.next = next;
        this.event = event;
    }

    @Override
    public void run() {
        if (isRunning()) {
            if (null != event) {
                try {
                    String sanitizedEvent = sanitize(event);
                    queueManager.publish(next,sanitizedEvent);

                    MetricsManager.ok(Queues.SANITIZER_QUEUE.name());
                } catch (Exception e) {
                    MetricsManager.error(Queues.SANITIZER_QUEUE.name());
                }
            }
        }
        System.out.println("Worker[" + this.getClass().getSimpleName() +
                "~" + Thread.currentThread().getName() +
                "] completed. ");
    }

    private String sanitize(String event) {
        SilentThread.sleep(FeatureFlagManager.get(FeatureFlagManager.WORKER_SANITIZER_TIME_BACKPRESSURE_MS));
        return event.trim().toLowerCase();
    }

}
