package com.github.diegopacheco.sandboxspring.service;

import org.springframework.stereotype.Service;

@Service
public class LoggingService {

    public void info(String msg){
        System.out.println(msg);
    }

}
