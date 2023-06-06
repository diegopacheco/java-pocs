package com.github.diegopacheco.java.pocs.workflow.chain.tasks;

import com.github.diegopacheco.java.pocs.workflow.chain.Context;
import com.github.diegopacheco.java.pocs.workflow.chain.Task;

public class GetWater implements Task {

    @Override
    public Class<SelectCoffee> next() {
        return SelectCoffee.class;
    }

    @Override
    public Boolean execute(Context context) {
        System.out.println("Getting water. Boiling water. ");
        return true;
    }
}
