package com.github.diegopacheco.pocs.seda.worker;

public interface Worker extends Runnable{
    void run();
    void drain();
    void resume();
}
