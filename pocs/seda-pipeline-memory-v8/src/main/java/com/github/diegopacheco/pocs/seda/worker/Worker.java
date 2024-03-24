package com.github.diegopacheco.pocs.seda.worker;

import com.github.diegopacheco.pocs.seda.event.Event;

import java.io.Serializable;

public interface Worker extends Runnable, Serializable {
    void run();
    Event<?> getEvent();
}
