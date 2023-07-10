package com.github.diegopacheco.hibernate.driver.wrapper;

import com.github.diegopacheco.hibernate.driver.observability.MetricsManager;
import com.mysql.cj.jdbc.ConnectionImpl;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLObservableDriver implements java.sql.Driver {

    Logger log = Logger.getLogger(MySQLObservableDriver.class.getName());

    private final Driver driver = getInstance();
    private Driver getInstance(){
        try{
            log.log(Level.FINEST,"[OBSERVABLE DRIVER] creating instance of REAL driver under the hood... ");
            return new Driver();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        log.log(Level.FINEST,"[OBSERVABLE DRIVER] creating connection... ");
        Connection conn = driver.connect(url,info);
        ConnectionWrapper wrapper = new ConnectionWrapper((ConnectionImpl) conn);
        MetricsManager.incConnection();
        return wrapper;
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return driver.acceptsURL(url);
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return driver.getPropertyInfo(url,info);
    }

    @Override
    public int getMajorVersion() {
        return driver.getMajorVersion();
    }

    @Override
    public int getMinorVersion() {
        return driver.getMinorVersion();
    }

    @Override
    public boolean jdbcCompliant() {
        return driver.jdbcCompliant();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return driver.getParentLogger();
    }

}
