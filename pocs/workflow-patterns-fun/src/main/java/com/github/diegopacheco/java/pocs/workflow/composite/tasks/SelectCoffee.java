package com.github.diegopacheco.java.pocs.workflow.composite.tasks;

import com.github.diegopacheco.java.pocs.workflow.composite.Context;
import com.github.diegopacheco.java.pocs.workflow.composite.Task;

public class SelectCoffee implements Task {
    @Override
    public Boolean execute(Context context) {
        System.out.println("Selecting coffee: " + context.get("COFFEE_TYPE") );
        return true;
    }
}