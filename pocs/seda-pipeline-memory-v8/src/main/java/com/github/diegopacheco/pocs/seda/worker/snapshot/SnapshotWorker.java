package com.github.diegopacheco.pocs.seda.worker.snapshot;

import com.github.diegopacheco.pocs.seda.seda.Queues;
import com.github.diegopacheco.pocs.seda.worker.Worker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;
import java.util.UUID;

public class SnapshotWorker implements Worker {

    private Map<Queues, Map<UUID,Runnable>> processes;
    private Gson gson;

    public SnapshotWorker(Map<Queues, Map<UUID,Runnable>> processes) {
        this.processes = processes;

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        this.gson = builder.create();
    }

    @Override
    public void run() {
        System.out.println("[SnapshotWorker] Snapshotting... ");
        for (Queues queue : processes.keySet()){
            System.out.println("Total [" + processes.get(queue).keySet().size() +
                    "] workers pending per queue: " + queue);
            for (UUID workerID : processes.get(queue).keySet()){
                Worker worker = (Worker)processes.get(queue).get(workerID);
                String json = gson.toJson(worker);
            }
        }
    }

}
