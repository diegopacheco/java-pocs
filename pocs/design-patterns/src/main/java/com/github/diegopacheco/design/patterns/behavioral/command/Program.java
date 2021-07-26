package com.github.diegopacheco.design.patterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static List<Command> commands() {
        List<Command> queue = new ArrayList<>();
        queue.add(new BuildCommand());
        queue.add(new RunTestsCommand());
        queue.add(new DeployCommand());
        return queue;
    }

    public static void run(List<Command> commands,Object args) {
        for (Command command : commands) {
            if (command.shouldRun(args))
                command.execute(args);
        }
    }

}
