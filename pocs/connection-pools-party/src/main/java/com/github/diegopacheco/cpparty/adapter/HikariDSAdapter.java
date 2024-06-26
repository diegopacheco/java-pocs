package com.github.diegopacheco.cpparty.adapter;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class HikariDSAdapter extends HikariDataSource implements DataSource {

    private HikariDataSource realDS;

    public HikariDSAdapter(HikariDataSource realDS){
        this.realDS = realDS;
    }

    @Override
    public Connection getConnection() throws SQLException {
        System.out.println("[HikariDSAdapter]HikariDSAdapter.getConnection() called.");
        return realDS.getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        System.out.println("[HikariDSAdapter]HikariDSAdapter.getConnection(username,password) called.");
        return realDS.getConnection(username,password);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        System.out.println("[HikariDSAdapter]HikariDSAdapter.getLogWriter() called.");
        return realDS.getLogWriter();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        System.out.println("[HikariDSAdapter]HikariDSAdapter.setLogWriter() called.");
        realDS.setLogWriter(out);
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        System.out.println("[HikariDSAdapter]HikariDSAdapter.setLoginTimeout() called.");
        realDS.setLoginTimeout(seconds);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        System.out.println("[HikariDSAdapter]HikariDSAdapter.getLoginTimeout() called.");
        return realDS.getLoginTimeout();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        System.out.println("[HikariDSAdapter]HikariDSAdapter.getParentLogger() called.");
        return realDS.getParentLogger();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        System.out.println("[HikariDSAdapter]HikariDSAdapter.unwrap() called.");
        return realDS.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        System.out.println("[HikariDSAdapter]HikariDSAdapter.isWrapperFor() called.");
        return realDS.isWrapperFor(iface);
    }
}
