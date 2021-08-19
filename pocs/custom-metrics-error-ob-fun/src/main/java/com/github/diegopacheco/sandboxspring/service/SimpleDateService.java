package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.metrics.OperationMonitor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SimpleDateService implements DateService{

    @Override
    public String getCurrentDate() {
        long init = System.currentTimeMillis();
        try{
            if (Math.random()*2000>1000){
                OperationMonitor.recordSuccess("getCurrentDate");
                return new Date().toString();
            }
            throw new RuntimeException("Random Exception!");
        }catch(Exception e){
            OperationMonitor.recordError("getCurrentDate");
            OperationMonitor.recordException("getCurrentDate",e);
            throw new RuntimeException(e);
        }finally{
            long end = System.currentTimeMillis();
            long diff = end - init;
            OperationMonitor.recordLatency("getCurrentDate",diff);
        }
    }

}
