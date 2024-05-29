package com.github.diegopacheco.sandboxspring.infra;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@Component
public class ConnectionRefresher {

    @Autowired
    private PlatformTransactionManager txManager;

    @Autowired
    private HikariDataSource ds;

    private boolean done = false;

    @Scheduled(fixedRate = 1000)
    public void refresh(){
        if (!done){
            System.out.println("Refreshing connection... TX manager: " + txManager + " - DS: " + ds);
            ds.getHikariPoolMXBean().softEvictConnections();
            done = true;
            System.out.println("Connection refreshed!");
        }
        System.out.println("*** TX manager: " + txManager + " - DS: " + ds);
        System.out.println(" Active connections : " + ds.getHikariPoolMXBean().getActiveConnections());
        System.out.println(" Idle connections   : " + ds.getHikariPoolMXBean().getIdleConnections());
        System.out.println(" Total connections  : " + ds.getHikariPoolMXBean().getTotalConnections());
    }

}
