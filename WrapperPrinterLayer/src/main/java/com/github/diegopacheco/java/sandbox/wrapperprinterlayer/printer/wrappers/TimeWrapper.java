package com.github.diegopacheco.java.sandbox.wrapperprinterlayer.printer.wrappers;

import com.github.diegopacheco.java.sandbox.wrapperprinterlayer.printer.PrintWrapper;

import java.util.Date;

/**
 * Created by diego on 7/17/2014.
 */
public class TimeWrapper implements PrintWrapper{

    @Override
    public String print(String content) {
        return new Date().getTime() + " - " + content;
    }
}
