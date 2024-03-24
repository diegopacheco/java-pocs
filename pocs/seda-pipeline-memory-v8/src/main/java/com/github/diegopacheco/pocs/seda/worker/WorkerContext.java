package com.github.diegopacheco.pocs.seda.worker;

import com.github.diegopacheco.pocs.seda.event.Event;
import com.github.diegopacheco.pocs.seda.seda.Queues;
import com.github.diegopacheco.pocs.seda.seda.SEDAManager;

public class WorkerContext {

    private SEDAManager sedaManager;
    private Queues next;
    private Event<String> event;
    private CompletionHandler completionHandler;

    public WorkerContext(SEDAManager sedaManager, Queues next, Event<String> event, CompletionHandler completionHandler) {
        this.sedaManager = sedaManager;
        this.next = next;
        this.event = event;
        this.completionHandler = completionHandler;
    }

    public SEDAManager getSedaManager() {
        return sedaManager;
    }

    public Queues getNext() {
        return next;
    }

    public Event<String> getEvent() {
        return event;
    }

    public CompletionHandler getCompletionHandler() {
        return completionHandler;
    }

    @Override
    public String toString() {
        return "WorkerContext{" +
                "sedaManager=" + sedaManager +
                ", next=" + next +
                ", event=" + event +
                ", completionHandler=" + completionHandler +
                '}';
    }
}
