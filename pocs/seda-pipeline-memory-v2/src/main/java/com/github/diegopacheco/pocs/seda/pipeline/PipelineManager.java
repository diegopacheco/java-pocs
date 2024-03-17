package com.github.diegopacheco.pocs.seda.pipeline;

import com.github.diegopacheco.pocs.seda.queue.QueueManager;
import com.github.diegopacheco.pocs.seda.synthetic.RequestGenerator;
import com.github.diegopacheco.pocs.seda.thread.SilentThread;
import com.github.diegopacheco.pocs.seda.worker.CatWorker;
import com.github.diegopacheco.pocs.seda.worker.ConsoleWorker;
import com.github.diegopacheco.pocs.seda.worker.SanitizerWorker;
import com.github.diegopacheco.pocs.seda.worker.Worker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PipelineManager {

    private QueueManager<String> queueSanitizer = new QueueManager<>("queue-sanitizer");
    private QueueManager<String> queueCat = new QueueManager<>("queue-cat");
    private QueueManager<String> queueConsole = new QueueManager<>("queue-console");

    private Worker w1 = new SanitizerWorker(queueSanitizer,queueCat);
    private Worker w2 = new CatWorker(queueCat,queueConsole);
    private Worker w3 = new ConsoleWorker(queueConsole);

    public void run(){
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
        System.out.println("*                      |-------------------|                |-------------------|                |-------------------| ");
        System.out.println("* events --> [in-queue]|-- sanitizer(W1) --|  ==> [in-queue]|-- cat(W2) --------|  ==> [in-queue]|-- console(W3) ----| ");
        System.out.println("*                      |-------------------|                |-------------------|                |-------------------| ");
        System.out.println("* ");
        System.out.println("* STARTED !");

        generate(1);

        for(Thread t: threads){
            t.start();
        }
        for(Thread t: threads){
            SilentThread.join(t);
        }
    }

    public void publish(String event){
        queueSanitizer.publish(event);
    }

    public void generate(int amount){
        RequestGenerator generator = new RequestGenerator();
        generator.generate(amount,queueSanitizer);
        System.out.println("* >>> " + amount + " events generated! ");
    }

}

