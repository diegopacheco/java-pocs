package com.github.diegopacheco.java.pocs.workflow.decorator;

// Now Task does not know order :-) Dont know who is first or second or last or
// how many steps there are present in the whole workflow.
// With Decorator - we can do any execution order, even repeat Tasks.
public interface Task {
    Boolean execute(Context context);
}
