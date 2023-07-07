package com.github.diegopacheco.hibernate.driver.observability;

import com.mysql.cj.ServerVersion;
import com.mysql.cj.Session;
import com.mysql.cj.exceptions.ExceptionInterceptor;
import com.mysql.cj.interceptors.QueryInterceptor;
import com.mysql.cj.jdbc.*;
import com.mysql.cj.jdbc.result.CachedResultSetMetaData;
import com.mysql.cj.jdbc.result.ResultSetInternalMethods;
import com.mysql.cj.protocol.ServerSessionStateController;

import java.io.Serializable;
import java.sql.*;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ConnectionWrapper implements JdbcConnection, Session.SessionEventListener, Serializable {

    private ConnectionImpl connection;
    public ConnectionWrapper(ConnectionImpl connection) {
        this.connection = connection;
    }

    @Override
    public void handleNormalClose() {
        connection.handleNormalClose();
    }

    @Override
    public void handleReconnect() {
        connection.handleReconnect();
    }

    @Override
    public void handleCleanup(Throwable whyCleanedUp) {
        connection.handleCleanup(whyCleanedUp);
    }

    @Override
    public JdbcPropertySet getPropertySet() {
        return connection.getPropertySet();
    }

    @Override
    public void createNewIO(boolean isForReconnect) {
        connection.createNewIO(isForReconnect);
    }

    @Override
    public long getId() {
        return connection.getId();
    }

    @Override
    public Properties getProperties() {
        return connection.getProperties();
    }

    @Override
    public Object getConnectionMutex() {
        return connection.getConnectionMutex();
    }

    @Override
    public Session getSession() {
        return connection.getSession();
    }

    @Override
    public String getURL() {
        return connection.getURL();
    }

    @Override
    public String getUser() {
        return connection.getUser();
    }

    @Override
    public ExceptionInterceptor getExceptionInterceptor() {
        return connection.getExceptionInterceptor();
    }

    @Override
    public void checkClosed() {
        connection.checkClosed();
    }

    @Override
    public void normalClose() {
        connection.normalClose();
    }

    @Override
    public void cleanup(Throwable whyCleanedUp) {
        connection.cleanup(whyCleanedUp);
    }

    @Override
    public ServerSessionStateController getServerSessionStateController() {
        return null;
    }

    @Override
    public void changeUser(String userName, String newPassword) throws SQLException {
        connection.changeUser(userName,newPassword);
    }

    @Override
    public void clearHasTriedMaster() {
        connection.clearHasTriedMaster();
    }

    @Override
    public PreparedStatement clientPrepareStatement(String sql) throws SQLException {
        return connection.clientPrepareStatement(sql);
    }

    @Override
    public PreparedStatement clientPrepareStatement(String sql, int autoGenKeyIndex) throws SQLException {
        return connection.clientPrepareStatement(sql,autoGenKeyIndex);
    }

    @Override
    public PreparedStatement clientPrepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return connection.clientPrepareStatement(sql,resultSetType,resultSetConcurrency);
    }

    @Override
    public PreparedStatement clientPrepareStatement(String sql, int[] autoGenKeyIndexes) throws SQLException {
        return connection.clientPrepareStatement(sql,autoGenKeyIndexes);
    }

    @Override
    public PreparedStatement clientPrepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return connection.clientPrepareStatement(sql,resultSetType,resultSetConcurrency,resultSetHoldability);
    }

    @Override
    public PreparedStatement clientPrepareStatement(String sql, String[] autoGenKeyColNames) throws SQLException {
        return connection.clientPrepareStatement(sql,autoGenKeyColNames);
    }

    @Override
    public int getActiveStatementCount() {
        return connection.getActiveStatementCount();
    }

    @Override
    public long getIdleFor() {
        return connection.getIdleFor();
    }

    @Override
    public String getStatementComment() {
        return connection.getStatementComment();
    }

    @Override
    public boolean hasTriedMaster() {
        return connection.hasTriedMaster();
    }

    @Override
    public boolean isInGlobalTx() {
        return connection.isInGlobalTx();
    }

    @Override
    public void setInGlobalTx(boolean flag) {
        connection.setInGlobalTx(flag);
    }

    @Override
    public boolean isSourceConnection() {
        return connection.isSourceConnection();
    }

    @Override
    public boolean isSameResource(JdbcConnection c) {
        return connection.isSameResource(c);
    }

    @Override
    public boolean lowerCaseTableNames() {
        return connection.lowerCaseTableNames();
    }

    @Override
    public void ping() throws SQLException {
        connection.ping();
    }

    @Override
    public void resetServerState() throws SQLException {
        connection.resetServerState();
    }

    @Override
    public PreparedStatement serverPrepareStatement(String sql) throws SQLException {
        return connection.serverPrepareStatement(sql);
    }

    @Override
    public PreparedStatement serverPrepareStatement(String sql, int autoGenKeyIndex) throws SQLException {
        return connection.serverPrepareStatement(sql,autoGenKeyIndex);
    }

    @Override
    public PreparedStatement serverPrepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return connection.serverPrepareStatement(sql,resultSetType,resultSetConcurrency);
    }

    @Override
    public PreparedStatement serverPrepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return connection.serverPrepareStatement(sql,resultSetType,resultSetConcurrency,resultSetHoldability);
    }

    @Override
    public PreparedStatement serverPrepareStatement(String sql, int[] autoGenKeyIndexes) throws SQLException {
        return connection.serverPrepareStatement(sql,autoGenKeyIndexes);
    }

    @Override
    public PreparedStatement serverPrepareStatement(String sql, String[] autoGenKeyColNames) throws SQLException {
        return null;
    }

    @Override
    public void setFailedOver(boolean flag) {
        connection.setFailedOver(flag);
    }

    @Override
    public void setStatementComment(String comment) {
        connection.setStatementComment(comment);
    }

    @Override
    public void shutdownServer() throws SQLException {
        connection.shutdownServer();
    }

    @Override
    public int getAutoIncrementIncrement() {
        return connection.getAutoIncrementIncrement();
    }

    @Override
    public boolean hasSameProperties(JdbcConnection c) {
        return connection.hasSameProperties(c);
    }

    @Override
    public String getHost() {
        return connection.getHost();
    }

    @Override
    public String getHostPortPair() {
        return connection.getHostPortPair();
    }

    @Override
    public void setProxy(JdbcConnection proxy) {
        connection.setProxy(proxy);
    }

    @Override
    public boolean isServerLocal() throws SQLException {
        return connection.isServerLocal();
    }

    @Override
    public int getSessionMaxRows() {
        return connection.getSessionMaxRows();
    }

    @Override
    public void setSessionMaxRows(int max) throws SQLException {
        connection.setSessionMaxRows(max);
    }

    @Override
    public void abortInternal() throws SQLException {
        connection.abortInternal();
    }

    @Override
    public boolean isProxySet() {
        return connection.isProxySet();
    }

    @Override
    public CachedResultSetMetaData getCachedMetaData(String sql) {
        return connection.getCachedMetaData(sql);
    }

    @Override
    public String getCharacterSetMetadata() {
        return connection.getCharacterSetMetadata();
    }

    @Override
    public Statement getMetadataSafeStatement() throws SQLException {
        return connection.getMetadataSafeStatement();
    }

    @Override
    public ServerVersion getServerVersion() {
        return getServerVersion();
    }

    @Override
    public List<QueryInterceptor> getQueryInterceptorsInstances() {
        return connection.getQueryInterceptorsInstances();
    }

    @Override
    public void initializeResultsMetadataFromCache(String sql, CachedResultSetMetaData cachedMetaData, ResultSetInternalMethods resultSet) throws SQLException {
        connection.initializeResultsMetadataFromCache(sql,cachedMetaData,resultSet);
    }

    @Override
    public void initializeSafeQueryInterceptors() throws SQLException {
        connection.initializeSafeQueryInterceptors();
    }

    @Override
    public boolean isReadOnly(boolean useSessionStatus) throws SQLException {
        return connection.isReadOnly();
    }

    @Override
    public void pingInternal(boolean checkForClosedConnection, int timeoutMillis) throws SQLException {
        connection.pingInternal(checkForClosedConnection,timeoutMillis);
    }

    @Override
    public void realClose(boolean calledExplicitly, boolean issueRollback, boolean skipLocalTeardown, Throwable reason) throws SQLException {
        connection.realClose(calledExplicitly,issueRollback,skipLocalTeardown,reason);
    }

    @Override
    public void recachePreparedStatement(JdbcPreparedStatement pstmt) throws SQLException {
        connection.recachePreparedStatement(pstmt);
    }

    @Override
    public void decachePreparedStatement(JdbcPreparedStatement pstmt) throws SQLException {
        connection.recachePreparedStatement(pstmt);
    }

    @Override
    public void registerStatement(JdbcStatement stmt) {
        connection.registerStatement(stmt);
    }

    @Override
    public void setReadOnlyInternal(boolean readOnlyFlag) throws SQLException {
        connection.isReadOnly(readOnlyFlag);
    }

    @Override
    public boolean storesLowerCaseTableName() {
        return connection.storesLowerCaseTableName();
    }

    @Override
    public void throwConnectionClosedException() throws SQLException {
        connection.throwConnectionClosedException();
    }

    @Override
    public void unregisterStatement(JdbcStatement stmt) {
        connection.unregisterStatement(stmt);
    }

    @Override
    public void unSafeQueryInterceptors() throws SQLException {
        connection.unSafeQueryInterceptors();
    }

    @Override
    public JdbcConnection getMultiHostSafeProxy() {
        return connection.getMultiHostSafeProxy();
    }

    @Override
    public JdbcConnection getMultiHostParentProxy() {
        return connection.getMultiHostParentProxy();
    }

    @Override
    public JdbcConnection getActiveMySQLConnection() {
        return connection.getActiveMySQLConnection();
    }

    @Override
    public ClientInfoProvider getClientInfoProviderImpl() throws SQLException {
        return connection.getClientInfoProviderImpl();
    }

    @Override
    public void setDatabase(String dbName) throws SQLException {
        connection.setDatabase(dbName);
    }

    @Override
    public String getDatabase() throws SQLException {
        return connection.getDatabase();
    }

    @Override
    public void transactionBegun() {
        connection.transactionBegun();
    }

    @Override
    public void transactionCompleted() {
        connection.transactionCompleted();
    }

    @Override
    public Statement createStatement() throws SQLException {
        Statement stmt = connection.createStatement();
        StatementWrapper wrapper = new StatementWrapper(stmt);
        return wrapper;
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        PreparedStatementWrapper wrapper = new PreparedStatementWrapper(preparedStatement);
        return wrapper;
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        return connection.prepareCall(sql);
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        return connection.nativeSQL(sql);
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        connection.setAutoCommit(autoCommit);
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return connection.getAutoCommit();
    }

    @Override
    public void commit() throws SQLException {
        connection.commit();
    }

    @Override
    public void rollback() throws SQLException {
        connection.rollback();
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return connection.isClosed();
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return connection.getMetaData();
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        connection.setReadOnly(readOnly);
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return connection.isReadOnly();
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {
        connection.setCatalog(catalog);
    }

    @Override
    public String getCatalog() throws SQLException {
        return connection.getCatalog();
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        connection.setTransactionIsolation(level);
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return connection.getTransactionIsolation();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return connection.getWarnings();
    }

    @Override
    public void clearWarnings() throws SQLException {
        connection.clearWarnings();
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return connection.createStatement(resultSetType,resultSetConcurrency);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return connection.prepareStatement(sql,resultSetType,resultSetConcurrency);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return connection.prepareCall(sql,resultSetType,resultSetConcurrency);
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return connection.getTypeMap();
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        connection.setTypeMap(map);
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
        connection.setHoldability(holdability);
    }

    @Override
    public int getHoldability() throws SQLException {
        return connection.getHoldability();
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        return connection.setSavepoint();
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        return connection.setSavepoint(name);
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        connection.rollback(savepoint);
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        connection.releaseSavepoint(savepoint);
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return connection.createStatement(resultSetType,resultSetConcurrency,resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return connection.prepareStatement(sql,resultSetType,resultSetConcurrency,resultSetHoldability);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return connection.prepareCall(sql,resultSetType,resultSetConcurrency,resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return connection.prepareStatement(sql,autoGeneratedKeys);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return connection.prepareStatement(sql,columnIndexes);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return connection.prepareStatement(sql,columnNames);
    }

    @Override
    public Clob createClob() throws SQLException {
        return connection.createClob();
    }

    @Override
    public Blob createBlob() throws SQLException {
        return connection.createBlob();
    }

    @Override
    public NClob createNClob() throws SQLException {
        return connection.createNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        return connection.createSQLXML();
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        return connection.isValid(timeout);
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        connection.setClientInfo(name,value);
    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        connection.setClientInfo(properties);
    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        return connection.getClientInfo(name);
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return connection.getClientInfo();
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return connection.createArrayOf(typeName,elements);
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return connection.createStruct(typeName,attributes);
    }

    @Override
    public void setSchema(String schema) throws SQLException {
        connection.setSchema(schema);
    }

    @Override
    public String getSchema() throws SQLException {
        return connection.getSchema();
    }

    @Override
    public void abort(Executor executor) throws SQLException {
        connection.abort(executor);
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        connection.setNetworkTimeout(executor,milliseconds);
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return connection.getNetworkTimeout();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return connection.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return connection.isWrapperFor(iface);
    }
}
