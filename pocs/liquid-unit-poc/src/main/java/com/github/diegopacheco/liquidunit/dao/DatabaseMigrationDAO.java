package com.github.diegopacheco.liquidunit.dao;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseMigrationDAO {

    private static volatile Connection CONNECTION = null;
    private static final Object CONNECTION_LOCK = new Object();
    private static String MYSQL_DB;

    public DatabaseMigrationDAO() {}

    public static Connection getConnection() {
        if (null == CONNECTION) {
            synchronized (CONNECTION_LOCK) {
                if (null == CONNECTION) {
                    String url = null;
                    try {
                        Properties properties = new Properties();
                        FileInputStream input = new FileInputStream("src/main/resources/application.properties");
                        properties.load(input);
                        input.close();

                        int MYSQL_PORT = Integer.parseInt(properties.getProperty("db.port", "3306"));
                        String MYSQL_HOST = properties.getProperty("db.host", "127.0.0.1");
                        MYSQL_DB = properties.getProperty("db.database", "profile");
                        String MYSQL_USER = properties.getProperty("db.user", "root");
                        String MYSQL_PASSWORD = properties.getProperty("db.password", "?????");
                        url = String.format("jdbc:mysql://%s:%d/%s", MYSQL_HOST, MYSQL_PORT, MYSQL_DB);

                        CONNECTION = DriverManager.getConnection(url, MYSQL_USER, MYSQL_PASSWORD);

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return CONNECTION;
    }

    public void executeSqlFile(Path sqlFile) {
        try {
            Connection connection = getConnection();
            String content = new String(Files.readAllBytes(sqlFile));
            String[] statements = content.split(";");
            try (Statement stmt = connection.createStatement()) {
                for (String sql : statements) {
                    sql = sql.trim();
                    if (!sql.isEmpty()) {
                        stmt.execute(sql);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void executeSql(String sql) {
        try {
            Connection connection = getConnection();
            try (Statement stmt = connection.createStatement()) {
                stmt.execute(sql);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isTableEmpty(String tableName) {
        try {
            Connection connection = getConnection();
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM " + MYSQL_DB + "." + tableName)) {
                if (rs.next()) {
                    return rs.getInt(1) == 0;
                }
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean schemaExists(String schemaName){
        try{
            Connection connection = getConnection();
            try (PreparedStatement stmt = connection.prepareStatement(
                    "SELECT COUNT(*) FROM information_schema.schemata WHERE schema_name = ?")) {
                stmt.setString(1, schemaName);

                try (ResultSet rs = stmt.executeQuery()) {
                    assertTrue(rs.next());
                    int count = rs.getInt(1);
                    return count >= 1;
                }
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public boolean tableExists(String tableName) {
        Connection conn = getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(
                "SELECT COUNT(*) FROM information_schema.tables " +
                        "WHERE table_schema = ? AND table_name = ?")) {
            stmt.setString(1, MYSQL_DB);
            stmt.setString(2, tableName);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean columnExists(String tableName, String columnName) {
        Connection conn = getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(
                "SELECT COUNT(*) FROM information_schema.columns " +
                        "WHERE table_schema = ? AND table_name = ? AND column_name = ?")) {
            stmt.setString(1, MYSQL_DB);
            stmt.setString(2, tableName);
            stmt.setString(3, columnName);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isSameSchema(String schema) {
        return MYSQL_DB.equalsIgnoreCase(schema);
    }

    public int queryForInt(String sql) {
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanupDatabase() {
        Connection conn = getConnection();
        try {
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("DROP DATABASE IF EXISTS " + MYSQL_DB);
                stmt.executeUpdate("CREATE DATABASE " + MYSQL_DB);
                System.out.println("Database reset complete");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            if (null != CONNECTION) {
                CONNECTION.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
