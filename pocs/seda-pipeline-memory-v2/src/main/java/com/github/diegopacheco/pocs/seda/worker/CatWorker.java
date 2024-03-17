package com.github.diegopacheco.pocs.seda.worker;

import com.github.diegopacheco.pocs.seda.ff.FeatureFlagManager;
import com.github.diegopacheco.pocs.seda.metrics.MetricsManager;
import com.github.diegopacheco.pocs.seda.queue.QueueManager;
import com.github.diegopacheco.pocs.seda.thread.SilentThread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class CatWorker implements Worker{

    private QueueManager<String> inQueue;
    private QueueManager<String> outQueue;

    public CatWorker(QueueManager<String> inQueue, QueueManager<String> outQueue) {
        this.inQueue = inQueue;
        this.outQueue = outQueue;
    }

    @Override
    public void run() {
        while(true){
            String event = inQueue.consume();
            if (null!=event){
                try{
                    String jsonFact = getFact(event);
                    outQueue.publish(jsonFact);

                    MetricsManager.ok(outQueue.getName(),CatWorker.class.getSimpleName());
                }catch(Exception e){
                    MetricsManager.error(outQueue.getName(),CatWorker.class.getSimpleName());
                }

            }
        }
    }

    private String getFact(String event) {
        SilentThread.sleep(FeatureFlagManager.get(FeatureFlagManager.WORKER_CAT_TIME_BACKPRESSURE_MS));

        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL("https://catfact.ninja/fact?max_length=200");
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("X-CALLER-HEADER", event);
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            br.close();
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
        return "{ \"requester\": \"" + event + "\", \"result\": " + sb.toString() + "}";

    }
}
