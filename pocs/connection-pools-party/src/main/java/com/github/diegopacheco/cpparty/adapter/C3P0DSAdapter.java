package com.github.diegopacheco.cpparty.adapter;

import com.mchange.v2.c3p0.AbstractComboPooledDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.PooledDataSource;

import javax.naming.Referenceable;
import java.beans.PropertyVetoException;
import java.io.Serializable;
import java.util.Map;
import java.util.Properties;

public class C3P0DSAdapter extends AbstractComboPooledDataSource implements Serializable, Referenceable, PooledDataSource {

    private ComboPooledDataSource realDS;

    public C3P0DSAdapter(ComboPooledDataSource realDS) {
        super();
        this.realDS = realDS;
    }

    @Override
    public String getDescription() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getDescription() called...");
        return realDS.getDescription();
    }

    @Override
    public void setDescription(String description) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setDescription() called...");
        realDS.setDescription(description);
    }

    @Override
    public String getDriverClass() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getDriverClass() called...");
        return realDS.getDriverClass();
    }

    @Override
    public void setDriverClass(String driverClass) throws PropertyVetoException {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setDriverClass() called...");
        realDS.setDriverClass(driverClass);
    }

    @Override
    public boolean isForceUseNamedDriverClass() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.isForceUseNamedDriverClass() called...");
        return realDS.isForceUseNamedDriverClass();
    }

    @Override
    public void setForceUseNamedDriverClass(boolean forceUseNamedDriverClass) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setForceUseNamedDriverClass() called...");
        realDS.setForceUseNamedDriverClass(forceUseNamedDriverClass);
    }

    @Override
    public String getJdbcUrl() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getJdbcUrl() called...");
        return realDS.getJdbcUrl();
    }

    @Override
    public void setJdbcUrl(String jdbcUrl) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setJdbcUrl() called...");
        realDS.setJdbcUrl(jdbcUrl);
    }

    @Override
    public Properties getProperties() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getProperties() called...");
        return realDS.getProperties();
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setProperties() called...");
        realDS.setProperties(properties);
    }

    @Override
    public String getUser() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getUser() called...");
        return realDS.getUser();
    }

    @Override
    public void setUser(String user) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setUser() called...");
        realDS.setUser(user);
    }

    @Override
    public String getPassword() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getPassword() called...");
        return realDS.getPassword();
    }

    @Override
    public void setPassword(String password) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setPassword() called...");
        realDS.setPassword(password);
    }

    @Override
    public int getCheckoutTimeout() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getCheckoutTimeout() called...");
        return realDS.getCheckoutTimeout();
    }

    @Override
    public void setCheckoutTimeout(int checkoutTimeout) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setCheckoutTimeout() called...");
        realDS.setCheckoutTimeout(checkoutTimeout);
    }

    @Override
    public int getConnectionIsValidTimeout() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getConnectionIsValidTimeout() called...");
        return realDS.getConnectionIsValidTimeout();
    }

    @Override
    public void setConnectionIsValidTimeout(int connectionIsValidTimeout) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setConnectionIsValidTimeout() called...");
        realDS.setConnectionIsValidTimeout(connectionIsValidTimeout);
    }

    @Override
    public int getAcquireIncrement() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getAcquireIncrement() called...");
        return realDS.getAcquireIncrement();
    }

    @Override
    public void setAcquireIncrement(int acquireIncrement) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setAcquireIncrement() called...");
        realDS.setAcquireIncrement(acquireIncrement);
    }

    @Override
    public int getAcquireRetryAttempts() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getAcquireRetryAttempts() called...");
        return realDS.getAcquireRetryAttempts();
    }

    @Override
    public void setAcquireRetryAttempts(int acquireRetryAttempts) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setAcquireRetryAttempts() called...");
        realDS.setAcquireRetryAttempts(acquireRetryAttempts);
    }

    @Override
    public int getAcquireRetryDelay() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getAcquireRetryDelay() called...");
        return realDS.getAcquireRetryDelay();
    }

    @Override
    public void setAcquireRetryDelay(int acquireRetryDelay) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setAcquireRetryDelay() called...");
        realDS.setAcquireRetryDelay(acquireRetryDelay);
    }

    @Override
    public boolean isAutoCommitOnClose() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.isAutoCommitOnClose() called...");
        return realDS.isAutoCommitOnClose();
    }

    @Override
    public void setAutoCommitOnClose(boolean autoCommitOnClose) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setAutoCommitOnClose() called...");
        realDS.setAutoCommitOnClose(autoCommitOnClose);
    }

    @Override
    public String getContextClassLoaderSource() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getContextClassLoaderSource() called...");
        return realDS.getContextClassLoaderSource();
    }

    @Override
    public void setContextClassLoaderSource(String contextClassLoaderSource) throws PropertyVetoException {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setContextClassLoaderSource() called...");
        realDS.setContextClassLoaderSource(contextClassLoaderSource);
    }

    @Override
    public String getMarkSessionBoundaries() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getMarkSessionBoundaries() called...");
        return realDS.getMarkSessionBoundaries();
    }

    @Override
    public void setMarkSessionBoundaries(String markSessionBoundaries) throws PropertyVetoException {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setMarkSessionBoundaries() called...");
        realDS.setMarkSessionBoundaries(markSessionBoundaries);
    }

    @Override
    public String getConnectionTesterClassName() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getConnectionTesterClassName() called...");
        return realDS.getConnectionTesterClassName();
    }

    @Override
    public void setConnectionTesterClassName(String connectionTesterClassName) throws PropertyVetoException {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setConnectionTesterClassName() called...");
        realDS.setConnectionTesterClassName(connectionTesterClassName);
    }

    @Override
    public String getTaskRunnerFactoryClassName() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getTaskRunnerFactoryClassName() called...");
        return realDS.getTaskRunnerFactoryClassName();
    }

    @Override
    public void setTaskRunnerFactoryClassName(String taskRunnerFactoryClassName) throws PropertyVetoException {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setTaskRunnerFactoryClassName() called...");
        realDS.setTaskRunnerFactoryClassName(taskRunnerFactoryClassName);
    }

    @Override
    public String getAutomaticTestTable() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getAutomaticTestTable() called...");
        return realDS.getAutomaticTestTable();
    }

    @Override
    public void setAutomaticTestTable(String automaticTestTable) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setAutomaticTestTable() called...");
        realDS.setAutomaticTestTable(automaticTestTable);
    }

    @Override
    public boolean isForceIgnoreUnresolvedTransactions() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.isForceIgnoreUnresolvedTransactions() called...");
        return realDS.isForceIgnoreUnresolvedTransactions();
    }

    @Override
    public void setForceIgnoreUnresolvedTransactions(boolean forceIgnoreUnresolvedTransactions) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setForceIgnoreUnresolvedTransactions() called...");
        realDS.setForceIgnoreUnresolvedTransactions(forceIgnoreUnresolvedTransactions);
    }

    @Override
    public boolean isPrivilegeSpawnedThreads() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.isPrivilegeSpawnedThreads() called...");
        return realDS.isPrivilegeSpawnedThreads();
    }

    @Override
    public void setPrivilegeSpawnedThreads(boolean privilegeSpawnedThreads) {
        realDS.setPrivilegeSpawnedThreads(privilegeSpawnedThreads);
    }

    @Override
    public int getIdleConnectionTestPeriod() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getIdleConnectionTestPeriod() called...");
        return realDS.getIdleConnectionTestPeriod();
    }

    @Override
    public void setIdleConnectionTestPeriod(int idleConnectionTestPeriod) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setIdleConnectionTestPeriod() called...");
        realDS.setIdleConnectionTestPeriod(idleConnectionTestPeriod);
    }

    @Override
    public int getInitialPoolSize() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getInitialPoolSize() called...");
        return realDS.getInitialPoolSize();
    }

    @Override
    public void setInitialPoolSize(int initialPoolSize) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setInitialPoolSize() called...");
        realDS.setInitialPoolSize(initialPoolSize);
    }

    @Override
    public int getMaxIdleTime() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getMaxIdleTime() called...");
        return realDS.getMaxIdleTime();
    }

    @Override
    public void setMaxIdleTime(int maxIdleTime) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setMaxIdleTime() called...");
        realDS.setMaxIdleTime(maxIdleTime);
    }

    @Override
    public int getMaxPoolSize() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getMaxPoolSize() called...");
        return realDS.getMaxPoolSize();
    }

    @Override
    public void setMaxPoolSize(int maxPoolSize) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setMaxPoolSize() called...");
        realDS.setMaxPoolSize(maxPoolSize);
    }

    @Override
    public int getMaxStatements() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getMaxStatements() called...");
        return realDS.getMaxStatements();
    }

    @Override
    public void setMaxStatements(int maxStatements) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setMaxStatements() called...");
        realDS.setMaxStatements(maxStatements);
    }

    @Override
    public int getMaxStatementsPerConnection() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getMaxStatementsPerConnection() called...");
        return realDS.getMaxStatementsPerConnection();
    }

    @Override
    public void setMaxStatementsPerConnection(int maxStatementsPerConnection) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setMaxStatementsPerConnection() called...");
        realDS.setMaxStatementsPerConnection(maxStatementsPerConnection);
    }

    @Override
    public int getMinPoolSize() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getMinPoolSize() called...");
        return realDS.getMinPoolSize();
    }

    @Override
    public void setMinPoolSize(int minPoolSize) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setMinPoolSize() called...");
        realDS.setMinPoolSize(minPoolSize);
    }

    @Override
    public String getOverrideDefaultUser() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getOverrideDefaultUser() called...");
        return realDS.getOverrideDefaultUser();
    }

    @Override
    public void setOverrideDefaultUser(String overrideDefaultUser) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setOverrideDefaultUser() called...");
        realDS.setOverrideDefaultUser(overrideDefaultUser);
    }

    @Override
    public String getOverrideDefaultPassword() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getOverrideDefaultPassword() called...");
        return realDS.getOverrideDefaultPassword();
    }

    @Override
    public void setOverrideDefaultPassword(String overrideDefaultPassword) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setOverrideDefaultPassword() called...");
        realDS.setOverrideDefaultPassword(overrideDefaultPassword);
    }

    @Override
    public int getPropertyCycle() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getPropertyCycle() called...");
        return realDS.getPropertyCycle();
    }

    @Override
    public void setPropertyCycle(int propertyCycle) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setPropertyCycle() called...");
        realDS.setPropertyCycle(propertyCycle);
    }

    @Override
    public boolean isBreakAfterAcquireFailure() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.isBreakAfterAcquireFailure() called...");
        return realDS.isBreakAfterAcquireFailure();
    }

    @Override
    public void setBreakAfterAcquireFailure(boolean breakAfterAcquireFailure) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setBreakAfterAcquireFailure() called...");
        realDS.setBreakAfterAcquireFailure(breakAfterAcquireFailure);
    }

    @Override
    public boolean isTestConnectionOnCheckout() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.isTestConnectionOnCheckout() called...");
        return realDS.isTestConnectionOnCheckout();
    }

    @Override
    public void setTestConnectionOnCheckout(boolean testConnectionOnCheckout) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setTestConnectionOnCheckout() called...");
        realDS.setTestConnectionOnCheckout(testConnectionOnCheckout);
    }

    @Override
    public boolean isTestConnectionOnCheckin() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.isTestConnectionOnCheckin() called...");
        return realDS.isTestConnectionOnCheckin();
    }

    @Override
    public void setTestConnectionOnCheckin(boolean testConnectionOnCheckin) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setTestConnectionOnCheckin() called...");
        realDS.setTestConnectionOnCheckin(testConnectionOnCheckin);
    }

    @Override
    public boolean isAttemptResurrectOnCheckin() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.isAttemptResurrectOnCheckin() called...");
        return realDS.isAttemptResurrectOnCheckin();
    }

    @Override
    public void setAttemptResurrectOnCheckin(boolean attemptResurrectOnCheckin) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setAttemptResurrectOnCheckin() called...");
        realDS.setAttemptResurrectOnCheckin(attemptResurrectOnCheckin);
    }

    @Override
    public String getPreferredTestQuery() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getPreferredTestQuery() called...");
        return realDS.getPreferredTestQuery();
    }

    @Override
    public void setPreferredTestQuery(String preferredTestQuery) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setPreferredTestQuery() called...");
        realDS.setPreferredTestQuery(preferredTestQuery);
    }

    @Override
    public int getMaxAdministrativeTaskTime() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getMaxAdministrativeTaskTime() called...");
        return realDS.getMaxAdministrativeTaskTime();
    }

    @Override
    public void setMaxAdministrativeTaskTime(int maxAdministrativeTaskTime) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setMaxAdministrativeTaskTime() called...");
        realDS.setMaxAdministrativeTaskTime(maxAdministrativeTaskTime);
    }

    @Override
    public int getMaxIdleTimeExcessConnections() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getMaxIdleTimeExcessConnections() called...");
        return realDS.getMaxIdleTimeExcessConnections();
    }

    @Override
    public void setMaxIdleTimeExcessConnections(int maxIdleTimeExcessConnections) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setMaxIdleTimeExcessConnections() called...");
        realDS.setMaxIdleTimeExcessConnections(maxIdleTimeExcessConnections);
    }

    @Override
    public int getMaxConnectionAge() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getMaxConnectionAge() called...");
        return realDS.getMaxConnectionAge();
    }

    @Override
    public void setMaxConnectionAge(int maxConnectionAge) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setMaxConnectionAge() called...");
        realDS.setMaxConnectionAge(maxConnectionAge);
    }

    @Override
    public String getConnectionCustomizerClassName() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getConnectionCustomizerClassName() called...");
        return realDS.getConnectionCustomizerClassName();
    }

    @Override
    public void setConnectionCustomizerClassName(String connectionCustomizerClassName) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setConnectionCustomizerClassName() called...");
        realDS.setConnectionCustomizerClassName(connectionCustomizerClassName);
    }

    @Override
    public int getUnreturnedConnectionTimeout() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getUnreturnedConnectionTimeout() called...");
        return realDS.getUnreturnedConnectionTimeout();
    }

    @Override
    public void setUnreturnedConnectionTimeout(int unreturnedConnectionTimeout) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setUnreturnedConnectionTimeout() called...");
        realDS.setUnreturnedConnectionTimeout(unreturnedConnectionTimeout);
    }

    @Override
    public String getUserOverridesAsString() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getUserOverridesAsString() called...");
        return realDS.getUserOverridesAsString();
    }

    @Override
    public void setUserOverridesAsString(String uoas) throws PropertyVetoException {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setUserOverridesAsString() called...");
        realDS.setUserOverridesAsString(uoas);
    }

    @Override
    public Map getUserOverrides() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getUserOverrides() called...");
        return realDS.getUserOverrides();
    }

    @Override
    public boolean isDebugUnreturnedConnectionStackTraces() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.isDebugUnreturnedConnectionStackTraces() called...");
        return realDS.isDebugUnreturnedConnectionStackTraces();
    }

    @Override
    public void setDebugUnreturnedConnectionStackTraces(boolean debugUnreturnedConnectionStackTraces) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setDebugUnreturnedConnectionStackTraces() called...");
        realDS.setDebugUnreturnedConnectionStackTraces(debugUnreturnedConnectionStackTraces);
    }

    @Override
    public boolean isForceSynchronousCheckins() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.isForceSynchronousCheckins() called...");
        return realDS.isForceSynchronousCheckins();
    }

    @Override
    public void setForceSynchronousCheckins(boolean forceSynchronousCheckins) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setForceSynchronousCheckins() called...");
        realDS.setForceSynchronousCheckins(forceSynchronousCheckins);
    }

    @Override
    public int getStatementCacheNumDeferredCloseThreads() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getStatementCacheNumDeferredCloseThreads() called...");
        return realDS.getStatementCacheNumDeferredCloseThreads();
    }

    @Override
    public void setStatementCacheNumDeferredCloseThreads(int statementCacheNumDeferredCloseThreads) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setStatementCacheNumDeferredCloseThreads() called...");
        realDS.setStatementCacheNumDeferredCloseThreads(statementCacheNumDeferredCloseThreads);
    }

    @Override
    public String getFactoryClassLocation() {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.getFactoryClassLocation() called...");
        return realDS.getFactoryClassLocation();
    }

    @Override
    public void setFactoryClassLocation(String factoryClassLocation) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.setFactoryClassLocation() called...");
        realDS.setFactoryClassLocation(factoryClassLocation);
    }

    @Override
    public String toString(boolean show_config) {
        System.out.println("[C3P0DSAdapter]C3P0DSAdapter.toString() called...");
        return realDS.toString(show_config);
    }

}
