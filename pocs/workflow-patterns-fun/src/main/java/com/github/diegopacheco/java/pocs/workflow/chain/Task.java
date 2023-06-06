package com.github.diegopacheco.java.pocs.workflow.chain;

public interface Task {
    // Instead of class could be a spring-bean name but would be more fragile,
    // still can get spring bean by type(object type not interface).
    // Could be the object itself also if you don't use IoC.
    Class<? extends Task> next();
    Boolean execute(Context context);
}
