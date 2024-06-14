package com.github.diegopacheco.cpparty.infra;

import com.github.diegopacheco.cpparty.conf.DBConfiguration;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DBCP2Refresher implements ApplicationContextAware {

    ApplicationContext ctx;

    @Autowired
    private PlatformTransactionManager txManager;

    @Autowired
    private PoolingDataSource<PoolableConnection> ds;

    @Autowired
    private GenericObjectPool<PoolableConnection> connectionPool;

    @Autowired
    private DBConfiguration configuration;

    private boolean done = false;

    @Scheduled(fixedRate = 5000)
    public void refresh() throws Exception {
        if (!done) {
            System.out.println("Refreshing connections... TX manager: " + txManager + " - DS: " + ds);
            traceConnections();

            connectionPool.evict();

            done = true;
            System.out.println("Connection soft evicted!");

            traceConnections();
            traceConnections();
        }
        traceDS();
    }

    private void traceDS() {
        try{
            System.out.println("*** TX manager: " + txManager + " - DS: " + ds);
            System.out.println(" Active connections : " + connectionPool.getNumActive());
            System.out.println(" Idle connections   : " + connectionPool.getNumIdle());
        }catch(Exception e){
            System.out.printf("Error on traceDS: %s\n", e.getMessage());
        }
    }

    private void traceConnections() {
        traceDS();
        List<Connection> connectionList = new ArrayList<>(10);
        for (int i = 0; i < 7; i++) {
            Connection con = null;
            try {
                con = ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
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
                e.printStackTrace();
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
