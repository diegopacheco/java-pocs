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
    public String getCatalog() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getCatalog() called.");
        return realConfig.getCatalog();
    }

    @Override
    public void setCatalog(String catalog) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setCatalog() called.");
        realConfig.setCatalog(catalog);
    }

    @Override
    public long getConnectionTimeout() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getConnectionTimeout() called.");
        return realConfig.getConnectionTimeout();
    }

    @Override
    public void setConnectionTimeout(long connectionTimeoutMs) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setConnectionTimeout() called.");
        realConfig.setConnectionTimeout(connectionTimeoutMs);
    }

    @Override
    public long getIdleTimeout() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getIdleTimeout() called.");
        return realConfig.getIdleTimeout();
    }

    @Override
    public void setIdleTimeout(long idleTimeoutMs) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setIdleTimeout() called.");
        realConfig.setIdleTimeout(idleTimeoutMs);
    }

    @Override
    public long getLeakDetectionThreshold() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getLeakDetectionThreshold() called.");
        return realConfig.getLeakDetectionThreshold();
    }

    @Override
    public void setLeakDetectionThreshold(long leakDetectionThresholdMs) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setLeakDetectionThreshold() called.");
        realConfig.setLeakDetectionThreshold(leakDetectionThresholdMs);
    }

    @Override
    public long getMaxLifetime() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getMaxLifetime() called.");
        return realConfig.getMaxLifetime();
    }

    @Override
    public void setMaxLifetime(long maxLifetimeMs) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setMaxLifetime() called.");
        realConfig.setMaxLifetime(maxLifetimeMs);
    }

    @Override
    public int getMaximumPoolSize() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getMaximumPoolSize() called.");
        return realConfig.getMaximumPoolSize();
    }

    @Override
    public void setMaximumPoolSize(int maxPoolSize) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setMaximumPoolSize() called.");
        realConfig.setMaximumPoolSize(maxPoolSize);
    }

    @Override
    public int getMinimumIdle() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getMinimumIdle() called.");
        return realConfig.getMinimumIdle();
    }

    @Override
    public void setMinimumIdle(int minIdle) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setMinimumIdle() called.");
        super.setMinimumIdle(minIdle);
    }

    @Override
    public void setPassword(String password) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setPassword() called.");
        realConfig.setPassword(password);
    }

    @Override
    public void setUsername(String username) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setUsername() called.");
        realConfig.setUsername(username);
    }

    @Override
    public long getValidationTimeout() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getValidationTimeout() called.");
        return realConfig.getValidationTimeout();
    }

    @Override
    public void setValidationTimeout(long validationTimeoutMs) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setValidationTimeout() called.");
        realConfig.setValidationTimeout(validationTimeoutMs);
    }

    @Override
    public void validate() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.validate() called.");
        realConfig.validate();
    }

}
