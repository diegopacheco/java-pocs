package com.github.diegopacheco.java.pocs.workflow.builder.tasks;

import com.github.diegopacheco.java.pocs.workflow.builder.Context;
import com.github.diegopacheco.java.pocs.workflow.builder.Task;

public class SelectCoffee implements Task {
    public Boolean execute(Context context) {
        System.out.println("Selecting coffee: " + context.get("COFFEE_TYPE") );
        return true;
    }
}
