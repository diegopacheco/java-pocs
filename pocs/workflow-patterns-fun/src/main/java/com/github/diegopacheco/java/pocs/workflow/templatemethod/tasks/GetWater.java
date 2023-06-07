package com.github.diegopacheco.java.pocs.workflow.templatemethod.tasks;

import com.github.diegopacheco.java.pocs.workflow.templatemethod.Context;
import com.github.diegopacheco.java.pocs.workflow.templatemethod.Task;

public class GetWater  implements Task {
    @Override
    public Boolean execute(Context context) {
        System.out.println("Getting water. Boiling water. ");
        return true;
    }
}
