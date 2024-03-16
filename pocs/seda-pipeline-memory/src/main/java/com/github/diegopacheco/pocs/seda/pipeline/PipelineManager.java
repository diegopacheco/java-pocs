package com.github.diegopacheco.pocs.seda.pipeline;

import com.github.diegopacheco.pocs.seda.queue.QueueManager;
import com.github.diegopacheco.pocs.seda.synthetic.RequestGenerator;
import com.github.diegopacheco.pocs.seda.thread.SilentThread;
import com.github.diegopacheco.pocs.seda.worker.CatWorker;
import com.github.diegopacheco.pocs.seda.worker.ConsoleWorker;
import com.github.diegopacheco.pocs.seda.worker.SanitizerWorker;
import com.github.diegopacheco.pocs.seda.worker.Worker;

import java.util.ArrayList;
import java.util.List;

public class PipelineManager {

    public void run(){

        QueueManager<String> queueSanitizer = new QueueManager<>();
        QueueManager<String> queueCat = new QueueManager<>();
        QueueManager<String> queueConsole = new QueueManager<>();

        Worker w1 = new SanitizerWorker(queueSanitizer,queueCat);
        Worker w2 = new CatWorker(queueCat,queueConsole);
        Worker w3 = new ConsoleWorker(queueConsole);

        List<Thread> threads = new ArrayList<Thread>();
        threads.add(new Thread(w1::run));
        threads.add(new Thread(w2::run));
        threads.add(new Thread(w3::run));

        System.out.println("**************************");
        System.out.println("*** Quem tem SEDA ? ******");
        System.out.println("**************************");
        System.out.println("* ");
        System.out.println("* Pipeline Manager ");
        System.out.println("* ");
        System.out.println("* |-------------------|       |-------------------|      |-------------------| ");
        System.out.println("* |-- sanitizer(W1) --|  ==>  |-- cat(W2) --------|  ==> |-- console(W3) ----| ");
        System.out.println("* |-------------------|       |-------------------|      |-------------------| ");
        System.out.println("* ");
        System.out.println("* STARTED !");

        RequestGenerator generator = new RequestGenerator();
        generator.generate(500,queueSanitizer);
        System.out.println("* >>> 500 events generated! ");

        for(Thread t: threads){
            t.start();
        }
        for(Thread t: threads){
            SilentThread.join(t);
        }
    }

}

