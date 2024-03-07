package com.github.diegopacheco.reactor.poc.ctx.service;

import com.github.diegopacheco.reactor.poc.ctx.config.Mid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    @Autowired Mid mid;

    public void log(String msg){
        System.out.println(msg + " MID: " + mid.getID());
    }

    public void log(String msg,Mid midPar){
        if (null!=midPar)
            System.out.println(msg + " MID: " + midPar.getID());
        else
            System.out.println(msg + " MID: <<NOT AVAILABLE>>");
    }

}
