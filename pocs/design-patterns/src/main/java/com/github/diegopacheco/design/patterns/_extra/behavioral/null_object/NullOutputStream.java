package com.github.diegopacheco.design.patterns._extra.behavioral.null_object;

import java.io.OutputStream;

class NullOutputStream extends OutputStream {
    public void write(int b) {
        // Do nothing
    }
}