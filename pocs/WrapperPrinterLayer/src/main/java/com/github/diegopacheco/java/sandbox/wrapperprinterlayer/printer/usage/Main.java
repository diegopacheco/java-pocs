package com.github.diegopacheco.java.sandbox.wrapperprinterlayer.printer.usage;

import com.github.diegopacheco.java.sandbox.wrapperprinterlayer.printer.ConsolePrinter;
import com.github.diegopacheco.java.sandbox.wrapperprinterlayer.printer.wrappers.AsteriscWrapper;
import com.github.diegopacheco.java.sandbox.wrapperprinterlayer.printer.wrappers.TimeWrapper;

/**
 * Created by diego on 7/17/2014.
 */
public class Main {
    public static void main(String args[]) {
        ConsolePrinter cp = new ConsolePrinter();
        cp.setWrapper(new AsteriscWrapper() {
            public String print(String content) {
                return super.print( new TimeWrapper().print(content));
            }
        });
        cp.print("Teste");
    }
}
