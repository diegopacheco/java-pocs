package com.github.diegopacheco.design.patterns._extra.creational.object_pool;

import java.sql.Connection;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) throws Exception{
        // Create the ConnectionPool:
        JDBCConnectionPool pool = new JDBCConnectionPool(
                "org.hsqldb.jdbcDriver", "jdbc:hsqldb:file:/tmp/db\\DB",
                "sa", "secret");

        // Get a connection:
        Connection con = pool.checkOut();

        // Use the connection
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM INFORMATION_SCHEMA.TABLES");
        System.out.println(rs.getFetchSize());

        // Return the connection:
        pool.checkIn(con);
    }
}
