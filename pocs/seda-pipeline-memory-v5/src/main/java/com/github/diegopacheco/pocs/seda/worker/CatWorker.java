package com.github.diegopacheco.pocs.seda.worker;

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

public class CatWorker implements Worker {

    private SEDAManager sedaManager;
    private Queues next;

    private Event<String> event;

    public CatWorker(SEDAManager sedaManager, Queues next, Event<String> event) {
        this.sedaManager = sedaManager;
        this.next = next;
        this.event = event;
    }

    @Override
    public void run() {
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
