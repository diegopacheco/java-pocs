package com.github.diegopacheco.cpparty.adapter;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.metrics.MetricsTrackerFactory;

import javax.sql.DataSource;
import java.util.Properties;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

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
    public String getConnectionTestQuery() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getConnectionTestQuery() called.");
        return realConfig.getConnectionTestQuery();
    }

    @Override
    public void setConnectionTestQuery(String connectionTestQuery) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setConnectionTestQuery() called.");
        realConfig.setConnectionTestQuery(connectionTestQuery);
    }

    @Override
    public String getConnectionInitSql() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getConnectionInitSql() called.");
        return realConfig.getConnectionInitSql();
    }

    @Override
    public void setConnectionInitSql(String connectionInitSql) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setConnectionInitSql() called.");
        realConfig.setConnectionInitSql(connectionInitSql);
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setDataSource() called.");
        realConfig.setDataSource(dataSource);
    }

    @Override
    public void setDataSourceClassName(String className) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setDataSourceClassName() called.");
        realConfig.setDataSourceClassName(className);
    }

    @Override
    public void addDataSourceProperty(String propertyName, Object value) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.addDataSourceProperty() called.");
        realConfig.addDataSourceProperty(propertyName, value);
    }

    @Override
    public String getDataSourceJNDI() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getDataSourceJNDI() called.");
        return realConfig.getDataSourceJNDI();
    }

    @Override
    public void setDataSourceJNDI(String jndiDataSource) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setDataSourceJNDI() called.");
        realConfig.setDataSourceJNDI(jndiDataSource);
    }

    @Override
    public void setDataSourceProperties(Properties dsProperties) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setDataSourceProperties() called.");
        realConfig.setDataSourceProperties(dsProperties);
    }

    @Override
    public String getDriverClassName() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getDriverClassName() called.");
        return realConfig.getDriverClassName();
    }

    @Override
    public void setDriverClassName(String driverClassName) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setDriverClassName() called.");
        realConfig.setDriverClassName(driverClassName);
    }

    @Override
    public void setJdbcUrl(String jdbcUrl) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setJdbcUrl() called.");
        realConfig.setJdbcUrl(jdbcUrl);
    }

    @Override
    public boolean isAutoCommit() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.isAutoCommit() called.");
        return realConfig.isAutoCommit();
    }

    @Override
    public void setAutoCommit(boolean isAutoCommit) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setAutoCommit() called.");
        realConfig.setAutoCommit(isAutoCommit);
    }

    @Override
    public boolean isAllowPoolSuspension() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.isAllowPoolSuspension() called.");
        return realConfig.isAllowPoolSuspension();
    }

    @Override
    public void setAllowPoolSuspension(boolean isAllowPoolSuspension) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setAllowPoolSuspension() called.");
        realConfig.setAllowPoolSuspension(isAllowPoolSuspension);
    }

    @Override
    public long getInitializationFailTimeout() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getInitializationFailTimeout() called.");
        return realConfig.getInitializationFailTimeout();
    }

    @Override
    public void setInitializationFailTimeout(long initializationFailTimeout) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setInitializationFailTimeout() called.");
        realConfig.setInitializationFailTimeout(initializationFailTimeout);
    }

    @Override
    public boolean isIsolateInternalQueries() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.isIsolateInternalQueries() called.");
        return realConfig.isIsolateInternalQueries();
    }

    @Override
    public void setIsolateInternalQueries(boolean isolate) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setIsolateInternalQueries() called.");
        realConfig.setIsolateInternalQueries(isolate);
    }

    @Override
    public MetricsTrackerFactory getMetricsTrackerFactory() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getMetricsTrackerFactory() called.");
        return realConfig.getMetricsTrackerFactory();
    }

    @Override
    public void setMetricsTrackerFactory(MetricsTrackerFactory metricsTrackerFactory) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setMetricsTrackerFactory() called.");
        realConfig.setMetricsTrackerFactory(metricsTrackerFactory);
    }

    @Override
    public Object getMetricRegistry() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getMetricRegistry() called.");
        return realConfig.getMetricRegistry();
    }

    @Override
    public void setMetricRegistry(Object metricRegistry) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setMetricRegistry() called.");
        realConfig.setMetricRegistry(metricRegistry);
    }

    @Override
    public Object getHealthCheckRegistry() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getHealthCheckRegistry() called.");
        return realConfig.getHealthCheckRegistry();
    }

    @Override
    public void setHealthCheckRegistry(Object healthCheckRegistry) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setHealthCheckRegistry() called.");
        realConfig.setHealthCheckRegistry(healthCheckRegistry);
    }

    @Override
    public Properties getHealthCheckProperties() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getHealthCheckProperties() called.");
        return realConfig.getHealthCheckProperties();
    }

    @Override
    public void setHealthCheckProperties(Properties healthCheckProperties) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setHealthCheckProperties() called.");
        realConfig.setHealthCheckProperties(healthCheckProperties);
    }

    @Override
    public void addHealthCheckProperty(String key, String value) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.addHealthCheckProperty() called.");
        realConfig.addHealthCheckProperty(key, value);
    }

    @Override
    public long getKeepaliveTime() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getKeepaliveTime() called.");
        return realConfig.getKeepaliveTime();
    }

    @Override
    public void setKeepaliveTime(long keepaliveTimeMs) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setKeepaliveTime() called.");
        realConfig.setKeepaliveTime(keepaliveTimeMs);
    }

    @Override
    public boolean isReadOnly() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.isReadOnly() called.");
        return realConfig.isReadOnly();
    }

    @Override
    public void setReadOnly(boolean readOnly) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setReadOnly() called.");
        realConfig.setReadOnly(readOnly);
    }

    @Override
    public boolean isRegisterMbeans() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.isRegisterMbeans() called.");
        return realConfig.isRegisterMbeans();
    }

    @Override
    public void setRegisterMbeans(boolean register) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setRegisterMbeans() called.");
        realConfig.setRegisterMbeans(register);
    }

    @Override
    public String getPoolName() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getPoolName() called.");
        return realConfig.getPoolName();
    }

    @Override
    public void setPoolName(String poolName) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setPoolName() called.");
        realConfig.setPoolName(poolName);
    }

    @Override
    public ScheduledExecutorService getScheduledExecutor() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getScheduledExecutor() called.");
        return realConfig.getScheduledExecutor();
    }

    @Override
    public void setScheduledExecutor(ScheduledExecutorService executor) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setScheduledExecutor() called.");
        realConfig.setScheduledExecutor(executor);
    }

    @Override
    public String getTransactionIsolation() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getTransactionIsolation() called.");
        return realConfig.getTransactionIsolation();
    }

    @Override
    public String getSchema() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getSchema() called.");
        return realConfig.getSchema();
    }

    @Override
    public void setSchema(String schema) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setSchema() called.");
        realConfig.setSchema(schema);
    }

    @Override
    public String getExceptionOverrideClassName() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getExceptionOverrideClassName() called.");
        return realConfig.getExceptionOverrideClassName();
    }

    @Override
    public void setExceptionOverrideClassName(String exceptionOverrideClassName) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setExceptionOverrideClassName() called.");
        realConfig.setExceptionOverrideClassName(exceptionOverrideClassName);
    }

    @Override
    public void setTransactionIsolation(String isolationLevel) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setTransactionIsolation() called.");
        realConfig.setTransactionIsolation(isolationLevel);
    }

    @Override
    public ThreadFactory getThreadFactory() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.getThreadFactory() called.");
        return realConfig.getThreadFactory();
    }

    @Override
    public void setThreadFactory(ThreadFactory threadFactory) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.setThreadFactory() called.");
        realConfig.setThreadFactory(threadFactory);
    }

    @Override
    public void copyStateTo(HikariConfig other) {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.copyStateTo() called.");
        realConfig.copyStateTo(other);
        other = this;
    }

    @Override
    public void validate() {
        System.out.println("[HikariConfigAdapter]HikariConfigAdapter.validate() called.");
        realConfig.validate();
    }

}
