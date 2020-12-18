package com.github.diegopacheco.sandboxspring.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SimpleDateService implements DateService {

    @Override
    public String getCurrentDate() {
        return new Date().toString();
    }

}
