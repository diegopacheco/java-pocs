package com.github.diegopacheco.pocs.seda.worker.snapshot;

import com.github.diegopacheco.pocs.seda.event.Event;
import com.github.diegopacheco.pocs.seda.seda.Queues;
import com.github.diegopacheco.pocs.seda.worker.Worker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class SnapshotWorker implements Worker {

    private Map<Queues, Map<UUID, Runnable>> processes;
    private Gson gson;

    public SnapshotWorker(Map<Queues, Map<UUID, Runnable>> processes) {
        this.processes = processes;

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        this.gson = builder.create();
    }

    @Override
    public void run() {
        System.out.println("[SnapshotWorker] Snapshotting... ");
        for (Queues queue : processes.keySet()) {
            System.out.println("Total [" + processes.get(queue).keySet().size() +
                    "] workers pending per queue: " + queue);
            for (UUID workerID : processes.get(queue).keySet()) {
                Worker worker = (Worker) processes.get(queue).get(workerID);
                if (null!=worker){
                    try{
                        String json = gson.toJson(worker.getEvent());
                        persist(queue + "_@_" + workerID.toString(),json);
                    }catch(Exception e){
                        System.out.println("Could not perform snapshot " + e);
                    }
                }
            }
        }
    }
    private void persist(String fileName, String content) {
        String path = null;
        try {
            path = new File(".").getCanonicalPath() + "/target/snapshot/";
            if (!new File(path).exists()){
                new File(path).mkdirs();
            }
            new File(path + fileName).createNewFile();

            BufferedWriter writer = new BufferedWriter(new FileWriter(path + fileName));
            writer.write(content);
            writer.close();
            System.out.println("[SnapshotWorker] persisted " + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Event<?> getEvent() {
        throw new UnsupportedOperationException("I'm a snapshotting worker not an event worker");
    }

}
