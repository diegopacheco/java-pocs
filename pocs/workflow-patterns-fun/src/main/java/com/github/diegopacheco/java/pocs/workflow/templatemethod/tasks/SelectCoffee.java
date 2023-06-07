package com.github.diegopacheco.java.pocs.workflow.templatemethod.tasks;

import com.github.diegopacheco.java.pocs.workflow.templatemethod.Context;
import com.github.diegopacheco.java.pocs.workflow.templatemethod.Task;

public class SelectCoffee implements Task {
    @Override
    public Boolean execute(Context context) {
        System.out.println("Selecting coffee: " + context.get("COFFEE_TYPE") );
        return true;
    }
}