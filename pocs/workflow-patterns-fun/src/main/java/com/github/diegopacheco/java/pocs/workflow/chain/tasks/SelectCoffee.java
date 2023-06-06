package com.github.diegopacheco.java.pocs.workflow.chain.tasks;

import com.github.diegopacheco.java.pocs.workflow.chain.Context;
import com.github.diegopacheco.java.pocs.workflow.chain.Task;

public class SelectCoffee implements Task {
    @Override
    public Class<BrewCoffee> next() {
        return BrewCoffee.class;
    }

    @Override
    public Boolean execute(Context context) {
        System.out.println("Selecting coffee: " + context.get("COFFEE_TYPE") );
        return true;
    }
}
