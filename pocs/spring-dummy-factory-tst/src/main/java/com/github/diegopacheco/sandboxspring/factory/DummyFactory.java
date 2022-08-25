package com.github.diegopacheco.sandboxspring.factory;

import com.github.diegopacheco.sandboxspring.service.DateService;
import com.github.diegopacheco.sandboxspring.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;

public class DummyFactory {

    private DummyFactory(){}

    @Inject
    DateService ds;

    @Autowired
    LoggingService ls;

    public static DummyFactory create(){
        return new DummyFactory();
    }

    public DateService getDs() {
        return ds;
    }

    public LoggingService getLs() {
        return ls;
    }
}
