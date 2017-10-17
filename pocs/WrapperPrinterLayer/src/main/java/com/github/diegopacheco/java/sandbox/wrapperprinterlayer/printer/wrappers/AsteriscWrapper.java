package com.github.diegopacheco.java.sandbox.wrapperprinterlayer.printer.wrappers;

import com.github.diegopacheco.java.sandbox.wrapperprinterlayer.printer.PrintWrapper;

/**
 * Created by diego on 7/17/2014.
 */
public class AsteriscWrapper implements PrintWrapper {

    @Override
    public String print(String content) {
        return "* " + content ;
    }
}
