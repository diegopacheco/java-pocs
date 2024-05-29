package com.github.diegopacheco.sandboxspring.infra;

import com.github.diegopacheco.sandboxspring.conf.DBConfiguration;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConnectionRefresher implements ApplicationContextAware {

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

            ds.getHikariPoolMXBean().softEvictConnections();
            done = true;
            System.out.println("Connection soft evicted!");

            /*
            // Dangerous
            DefaultListableBeanFactory bf = (DefaultListableBeanFactory)ctx.getAutowireCapableBeanFactory();
            DefaultListableBeanFactory defaultListableBeanFactory = bf;
            defaultListableBeanFactory.removeBeanDefinition("transactionManager");
            defaultListableBeanFactory.registerSingleton("transactionManager", configuration.txManager()); // No bean named 'transactionManager' available
            txManager = (PlatformTransactionManager) defaultListableBeanFactory.getBean("transactionManager");
            */

            txManager = (PlatformTransactionManager) ctx.getBean("transactionManager");
            ds = (HikariDataSource) ctx.getBean("dataSource");
            System.out.println("Connection refreshed!");
            traceConnections();
            traceConnections();
        }
        traceDS();
    }

    private void traceDS(){
        System.out.println("*** TX manager: " + txManager + " - DS: " + ds);
        System.out.println(" Active connections : " + ds.getHikariPoolMXBean().getActiveConnections());
        System.out.println(" Idle connections   : " + ds.getHikariPoolMXBean().getIdleConnections());
        System.out.println(" Total connections  : " + ds.getHikariPoolMXBean().getTotalConnections());
    }

    private void traceConnections(){
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
