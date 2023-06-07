package com.github.diegopacheco.java.pocs.workflow.templatemethod;

// Now Task does not know order :-) Dont know who is first or second or last or
// how many steps there are present in the whole workflow.
public interface Task {
    Boolean execute(Context context);
}
