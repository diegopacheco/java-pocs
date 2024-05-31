package com.github.diegopacheco.javapocs.test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.ClassRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class MySQLUsingJDBCTest {

    @ClassRule
    public static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:5.7");

    @BeforeAll
    static void startDb() throws SQLException {
        System.out.println("Setting up podman env");
        Map<String, String> newEnv = getModifiableEnvironmentMap();
        newEnv.put("DOCKER_HOST", "unix:///run/user/1000/podman/podman.sock");
        newEnv.put("TESTCONTAINERS_RYUK_DISABLED", "true");

        mysql.start();
        String url = mysql.getJdbcUrl();
        String user = mysql.getUsername();
        String password = mysql.getPassword();
        System.out.println("JDBC URL: " + url);
    }

    @AfterAll
    static void destroyDB() throws SQLException {
        mysql.stop();
    }

    @Test
    public void testJDBC() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(mysql.getJdbcUrl());
        config.setUsername(mysql.getUsername());
        config.setPassword(mysql.getPassword());
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        try (HikariDataSource ds = new HikariDataSource(config)) {

            try (Connection conn = ds.getConnection();
                 Statement stmt = conn.createStatement();
            ) {
                String sql = "CREATE TABLE USERS " +
                        "(id INTEGER not NULL, " +
                        " first VARCHAR(255), " +
                        " last VARCHAR(255), " +
                        " age INTEGER, " +
                        " PRIMARY KEY ( id ))";
                stmt.executeUpdate(sql);
                System.out.println("Created table users");
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

            try (Connection conn = ds.getConnection();
                 Statement stmt = conn.createStatement();
            ) {
                String sql = "INSERT INTO USERS VALUES (100, 'John', 'Doe', 18)";
                stmt.executeUpdate(sql);
                sql = "INSERT INTO USERS VALUES (101, 'Mary', 'Jane Watson', 25)";
                stmt.executeUpdate(sql);
                sql = "INSERT INTO USERS VALUES (102, 'Petter', 'Parker', 30)";
                stmt.executeUpdate(sql);
                sql = "INSERT INTO USERS VALUES(103, 'Ace', 'Ventura', 28)";
                stmt.executeUpdate(sql);
                System.out.println("Inserted records into the table USERS...");
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

            final String QUERY = "SELECT id, first, last, age FROM USERS";
            try (Connection conn = ds.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(QUERY);
            ) {
                while (rs.next()) {
                    System.out.print("ID: " + rs.getInt("id"));
                    System.out.print(", Age: " + rs.getInt("age"));
                    System.out.print(", First: " + rs.getString("first"));
                    System.out.println(", Last: " + rs.getString("last"));
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

    }

    private static Map<String, String> getModifiableEnvironmentMap() {
        try {
            Map<String, String> unmodifiableEnv = System.getenv();
            Class<?> cl = unmodifiableEnv.getClass();
            Field field = cl.getDeclaredField("m");
            field.setAccessible(true);
            Map<String, String> modifiableEnv = (Map<String, String>) field.get(unmodifiableEnv);
            return modifiableEnv;
        } catch (Exception e) {
            throw new RuntimeException("Unable to access writable environment variable map.");
        }
    }

}
