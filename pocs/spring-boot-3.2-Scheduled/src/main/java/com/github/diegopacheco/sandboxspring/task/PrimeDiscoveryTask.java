package com.github.diegopacheco.sandboxspring.task;

import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class PrimeDiscoveryTask {

    private static ConcurrentLinkedQueue<BigInteger> primes = new ConcurrentLinkedQueue<>();
    private static BigInteger stop = new BigInteger("1");

    @Scheduled(fixedRate = 3000)
    private static void logProgress(){
        System.out.println("Total primes discovered: " + primes.size());
    }

    @PostConstruct
    @Scheduled(fixedRate = 1000)
    private void calculatePrimes(){
        try{
            if (isPrime(stop)){
                primes.add(stop);
            }
            stop = stop.add(new BigInteger("1"));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private static boolean isPrime(BigInteger n) {
        return  n.isProbablePrime(n.intValue()/2);
    }

}
