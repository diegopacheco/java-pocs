package com.github.diegopacheco.pocs.seda.worker;

import com.github.diegopacheco.pocs.seda.queue.QueueManager;
import com.github.diegopacheco.pocs.seda.thread.SilentThread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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
                String jsonFact = getFact(event);
                outQueue.publish(jsonFact);
            }
        }
    }

    private String getFact(String event) {
        SilentThread.sleep(1);

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
        return sb.toString();
    }
}
