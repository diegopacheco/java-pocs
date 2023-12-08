package com.github.diegopacheco.sandboxspring.task;

import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class PrimeDiscoveryTask {

    private static ConcurrentLinkedQueue<BigInteger> primes;

    @Scheduled(fixedRate = 3000)
    private static void logProgress(){
        System.out.println("Total primes discovered: " + primes.size());
    }

    @PostConstruct
    private void calculatePrimes(){
        try{

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
