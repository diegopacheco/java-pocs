package com.github.diegopacheco.pocs.seda.worker;

import com.github.diegopacheco.pocs.seda.backpressure.LeakyBucketBackpressure;
import com.github.diegopacheco.pocs.seda.event.Event;
import com.github.diegopacheco.pocs.seda.ff.FeatureFlagManager;
import com.github.diegopacheco.pocs.seda.metrics.MetricsManager;
import com.github.diegopacheco.pocs.seda.seda.Queues;
import com.github.diegopacheco.pocs.seda.thread.SilentThread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;

public class CatWorker implements Worker {

    private static final LeakyBucketBackpressure buket = new LeakyBucketBackpressure();

    private WorkerContext context;

    private ExecutorService pool;

    public CatWorker(WorkerContext context, ExecutorService pool) {
        this.context = context;
        this.pool = pool;
    }

    @Override
    public void run() {
        LeakyBucketBackpressure.runWithBackpressure(buket, (x) -> {
            if (null != context.getEvent()) {
                try {
                    Event<String> jsonFactEvent = getFact(context.getEvent());
                    System.out.println(" >> " + jsonFactEvent);
                    context.getSedaManager().publish(context.getNext(), jsonFactEvent);

                    MetricsManager.ok(Queues.CAT_QUEUE.name());
                } catch (Exception e) {
                    MetricsManager.error(Queues.CAT_QUEUE.name());
                }
                context.getCompletionHandler().signalDone();
            }
            System.out.println("Worker[" + this.getClass().getSimpleName() +
                    "~" + Thread.currentThread().getName() +
                    "] completed. ");
        }, (z) -> {
            System.out.println("Worker[" + this.getClass().getSimpleName() +
                    "~" + Thread.currentThread().getName() +
                    "] BACKPRESSURE - DID NOT RUN. ");

            // Extra 10s as time backpressure to avoid too much CPU on busy waiting.
            SilentThread.sleep(
            ((int)FeatureFlagManager.get(
                      FeatureFlagManager.QUEUE_CAT_TIME_BACKPRESSURE_MS)) * 10);

            // re-submit for future retry.
            pool.submit(this);
        });
    }

    @Override
    public Event<?> getEvent() {
        return context.getEvent();
    }

    private Event<String> getFact(Event<String> event) {
        SilentThread.sleep(FeatureFlagManager.get(FeatureFlagManager.QUEUE_CAT_TIME_BACKPRESSURE_MS));

        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL("https://catfact.ninja/fact?max_length=200");
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("X-CALLER-HEADER", event.getContent());
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new Event("{ \"requester\": \"" + event.getContent() + "\", \"result\": " + sb.toString() + "}").addStage("CAT");

    }

}
