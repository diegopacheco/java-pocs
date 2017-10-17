package com.github.diegopacheco.sandbox.java.spring.wildfly.services;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service(value="simpleDateService")
public class SimpleDateService implements DateService{
    @Override
    public String currentTime() {
        return new Date().toString();
    }
}
