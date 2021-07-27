package com.github.diegopacheco.design.patterns._extra.behavioral.null_object;

import java.io.PrintStream;

// Null Object - Good for returning Types or Defaults so dont throw NPE.
class NullPrintStream extends PrintStream {
    public NullPrintStream() {
        super(new NullOutputStream());
    }
}