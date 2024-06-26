package com.github.diegopacheco.cpparty.infra;

import com.github.diegopacheco.cpparty.adapter.HikariDSAdapter;
import com.github.diegopacheco.cpparty.conf.DBConfiguration;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class HikariRefresher implements ApplicationContextAware {

    ApplicationContext ctx;

    @Autowired
    private PlatformTransactionManager txManager;

    @Autowired
    private HikariDataSource ds;

    @Autowired
    private DBConfiguration configuration;

    private boolean done = false;

    @Scheduled(fixedRate = 5000)
    public void refresh() throws Exception {
        if (!done) {
            System.out.println("Refreshing connections... TX manager: " + txManager + " - DS: " + ds);
            traceConnections();

            ds.setUsername("root");
            ds.setPassword("pass");

            // java.lang.IllegalStateException: The configuration of the pool is sealed once started. Use HikariConfigMXBean for runtime changes.
            //ds.setJdbcUrl("jdbc:mysql://127.0.0.1:3325/person");

            // force error - uncomment and an error will happen - this is good.
            // ((HikariDSAdapter)ds).toggle();

            ds.getHikariPoolMXBean().softEvictConnections();
            done = true;
            System.out.println("Connection soft evicted!");

            txManager = (PlatformTransactionManager) ctx.getBean("transactionManager");
            ds = (HikariDataSource) ctx.getBean("dataSource");
            System.out.println("Connection refreshed!");
            traceConnections();
            traceConnections();
        }
        traceDS();
    }

    private void traceDS() {
        System.out.println("*** TX manager: " + txManager + " - DS: " + ds);
        System.out.println(" Active connections : " + ds.getHikariPoolMXBean().getActiveConnections());
        System.out.println(" Idle connections   : " + ds.getHikariPoolMXBean().getIdleConnections());
        System.out.println(" Total connections  : " + ds.getHikariPoolMXBean().getTotalConnections());
    }

    private void traceConnections() {
        traceDS();
        List<Connection> connectionList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Connection con = null;
            try {
                con = ds.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println(con);
            connectionList.add(con);
        }
        traceDS();
        for (Connection con : connectionList) {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        traceDS();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}