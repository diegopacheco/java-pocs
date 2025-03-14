package com.github.diegopacheco.cpparty.adapter;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.lang.reflect.Field;
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
    public String getUsername() {
        System.out.println("[HikariDSAdapter]HikariDSAdapter.getUsername() called.");
        return realDS.getUsername();
    }

    @Override
    public String getPassword() {
        System.out.println("[HikariDSAdapter]HikariDSAdapter.getPassword() called.");
        return realDS.getPassword();
    }

    @Override
    public String getJdbcUrl() {
        System.out.println("[HikariDSAdapter]HikariDSAdapter.getJdbcUrl() called.");
        return realDS.getJdbcUrl();
    }

    private boolean toggle = false;

    public void toggle(){
        toggle = !toggle;
    }

    @Override
    public Connection getConnection() throws SQLException {
        System.out.println("[HikariDSAdapter]HikariDSAdapter.getConnection() called.");

        try{
            Field sealed = realDS.getClass().getSuperclass().getDeclaredField("sealed");
            sealed.setAccessible(true);
            sealed.set(realDS,false);

            // if toggle is true - simulate error on user.
            if (toggle){
                realDS.setUsername("root1-wrong-user");
            }else{
                realDS.setUsername("root");
            }
            realDS.setPassword("pass");
            realDS.setJdbcUrl("jdbc:mysql://127.0.0.1:3325/person");

        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            return realDS.getConnection();
        }catch(Exception e){
            System.out.println("Credentials does not work - refresh! ");

            // simulate get thr fresh right credentials....
            realDS.setUsername("root");
            realDS.setPassword("pass");
            realDS.setJdbcUrl("jdbc:mysql://127.0.0.1:3325/person");

            // get rid of the error
            toggle();
            return realDS.getConnection();
        }
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

    @Override
    public HikariPoolMXBean getHikariPoolMXBean() {
        System.out.println("[HikariDSAdapter]HikariDSAdapter.getHikariPoolMXBean() called.");
        return realDS.getHikariPoolMXBean();
    }

}
