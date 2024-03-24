package com.github.diegopacheco.pocs.seda.worker;

import com.github.diegopacheco.pocs.seda.seda.Queues;

import java.util.UUID;

public interface CompletionHandler {
    void signalDone();
}