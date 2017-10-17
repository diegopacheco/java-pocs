package com.github.diegopacheco.java.sandbox.wrapperprinterlayer.printer;

/**
 * Created by diego on 7/17/2014.
 */
public class ConsolePrinter implements Printer{

    private PrintWrapper wrapper;

    @Override
    public void print(String content) {
        System.out.print(wrapper.print(content));
    }

    public void setWrapper(PrintWrapper wrapper) {
        this.wrapper = wrapper;
    }
}
