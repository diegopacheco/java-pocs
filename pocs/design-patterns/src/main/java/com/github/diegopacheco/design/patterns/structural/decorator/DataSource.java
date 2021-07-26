package com.github.diegopacheco.design.patterns.structural.decorator;

public interface DataSource {
    boolean write(String data);
    String read();
}
