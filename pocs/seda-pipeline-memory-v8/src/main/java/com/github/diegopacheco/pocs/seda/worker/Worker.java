package com.github.diegopacheco.pocs.seda.worker;

import java.io.Serializable;

public interface Worker extends Runnable, Serializable {
    void run();
}
