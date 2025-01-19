package com.github.diegopacheco.sandboxspring.driver;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class AnonymizingMySQLDriver implements Driver {
    static {
        try {
            DriverManager.registerDriver(new AnonymizingMySQLDriver());
            System.out.println("[AnonymizingMySQLDriver] ***** registered!");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to register AnonymizingMySQLDriver", e);
        }
    }

    private final Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();

    public AnonymizingMySQLDriver() throws SQLException {
        System.out.println("[AnonymizingMySQLDriver] ***** created!");
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        return new AnonymizingConnection(mysqlDriver.connect(url, info));
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return mysqlDriver.acceptsURL(url);
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return mysqlDriver.getPropertyInfo(url, info);
    }

    @Override
    public int getMajorVersion() {
        return mysqlDriver.getMajorVersion();
    }

    @Override
    public int getMinorVersion() {
        return mysqlDriver.getMinorVersion();
    }

    @Override
    public boolean jdbcCompliant() {
        return mysqlDriver.jdbcCompliant();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return mysqlDriver.getParentLogger();
    }
}