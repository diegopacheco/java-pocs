package com.github.diegopacheco.sandboxspring.service;

import org.springframework.stereotype.Service;

import javax.inject.Named;
import java.util.Date;

@Named
public class DateService {

    public String getDate(){
        return new Date().toString();
    }

}
