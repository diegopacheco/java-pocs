package com.github.diegopacheco.pocs.seda.queue;

import java.util.Queue;

public interface EventQueue<T> {
    Queue<T> queue();
}
