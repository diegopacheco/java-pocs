package com.github.diegopacheco.design.patterns.behavioral.command;

public interface Command {
    void execute(Object context);
    boolean shouldRun(Object context);
}
