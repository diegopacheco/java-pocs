package com.github.diegopacheco.pocs.seda.worker;

import com.github.diegopacheco.pocs.seda.backpressure.LeakyBucketBackpressure;
import com.github.diegopacheco.pocs.seda.event.Event;
import com.github.diegopacheco.pocs.seda.ff.FeatureFlagManager;
import com.github.diegopacheco.pocs.seda.metrics.MetricsManager;
import com.github.diegopacheco.pocs.seda.seda.SEDAManager;
import com.github.diegopacheco.pocs.seda.seda.Queues;
import com.github.diegopacheco.pocs.seda.thread.SilentThread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;

public class CatWorker implements Worker {

    private static final LeakyBucketBackpressure buket = new LeakyBucketBackpressure();

    private SEDAManager sedaManager;
    private Queues next;

    private Event<String> event;

    private ExecutorService pool;

    public CatWorker(SEDAManager sedaManager, ExecutorService pool,Queues next, Event<String> event) {
        this.sedaManager = sedaManager;
        this.next = next;
        this.event = event;
        this.pool = pool;
    }

    @Override
    public void run() {
        LeakyBucketBackpressure.runWithBackpressure(buket, (x) -> {
            if (null != event) {
                try {
                    Event<String> jsonFactEvent = getFact(event);
                    System.out.println(" >> " + jsonFactEvent);
                    sedaManager.publish(next, jsonFactEvent);

                    MetricsManager.ok(Queues.CAT_QUEUE.name());
                } catch (Exception e) {
                    MetricsManager.error(Queues.CAT_QUEUE.name());
                }
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
