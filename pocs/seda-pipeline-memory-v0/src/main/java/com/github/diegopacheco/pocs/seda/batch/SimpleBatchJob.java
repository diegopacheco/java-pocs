package com.github.diegopacheco.pocs.seda.batch;

import com.github.diegopacheco.pocs.seda.metrics.MetricsManager;
import com.github.diegopacheco.pocs.seda.thread.SilentThread;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SimpleBatchJob {

    private static final Integer TOTAL_THREADS_PER_ALL = 3;

    private static ExecutorService pool = Executors.newFixedThreadPool(TOTAL_THREADS_PER_ALL);

    @PostConstruct
    public void init(){
        System.out.println("*************************************");
        System.out.println("*** Batch Job [SimpleBatchJob] ******");
        System.out.println("*************************************");
        System.out.println("* ");
        System.out.println("*                      |-----------------|        |-------------------|      |-------------------| ");
        System.out.println("* events --> [executor]|-- step(M1)    --|  ==>   |-- cat(M2) --------|  ==> |-- console(M3) ----| ");
        System.out.println("*                      |-----------------|        |-------------------|      |-------------------| ");
        System.out.println("* ");
        System.out.println("* STARTED !");
        System.out.println("* ");
    }

    public void submitWork(String event){
        pool.submit(createJob(event));
    }

    private Runnable createJob(final String event){
        return new Runnable() {
            @Override
            public void run() {
                try{
                    String processedEvent = step1(event);
                    processedEvent = step2(processedEvent);
                    step3(processedEvent);
                    MetricsManager.ok();
                }catch(Exception e){
                    MetricsManager.error();
                }
            }
        };
    }

    private String step1(String event) {
        return event.trim().toLowerCase();
    }

    private String step2(String event) {
        SilentThread.sleep(2);

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

    private void step3(String event){
        if (null != event) {
            try{
                SilentThread.sleep(1);
                System.out.println(new Date() + " - event finish pipeline.");
                System.out.println(event);
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }

    }
}
