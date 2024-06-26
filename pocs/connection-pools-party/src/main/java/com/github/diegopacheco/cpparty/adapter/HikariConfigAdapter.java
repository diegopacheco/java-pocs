package com.github.diegopacheco.cpparty.adapter;

import com.zaxxer.hikari.HikariConfig;

import javax.sql.DataSource;
import java.util.Properties;

public class HikariConfigAdapter extends HikariConfig {

    private HikariConfig realConfig;

    public HikariConfigAdapter(HikariConfig realConfig){
        super();
        this.realConfig = realConfig;
    }

    @Override
    public String getPassword() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getPassword() called.");
        return realConfig.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getUsername() called.");
        return realConfig.getUsername();
    }

    @Override
    public String getJdbcUrl() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getJdbcUrl() called.");
        return realConfig.getJdbcUrl();
    }

    @Override
    public Properties getDataSourceProperties() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getDataSourceProperties() called.");
        return realConfig.getDataSourceProperties();
    }

    @Override
    public String getDataSourceClassName() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getDataSourceClassName() called.");
        return realConfig.getDataSourceClassName();
    }

    @Override
    public DataSource getDataSource() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getDataSource() called.");
        return realConfig.getDataSource();
    }

    @Override
    public void validate() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.validate() called.");
        realConfig.validate();
    }

}
