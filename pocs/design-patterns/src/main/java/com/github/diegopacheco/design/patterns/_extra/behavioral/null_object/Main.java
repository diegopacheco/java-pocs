package com.github.diegopacheco.design.patterns._extra.behavioral.null_object;

import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        PrintStream ps = new NullPrintStream();
        ps.println("does something happens?");
    }
}
