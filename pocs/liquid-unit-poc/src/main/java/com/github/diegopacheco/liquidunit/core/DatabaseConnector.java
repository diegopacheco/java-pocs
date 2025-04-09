package com.github.diegopacheco.liquidunit.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private final LiquidUnitConfig config;
    private Connection connection;

    public DatabaseConnector(LiquidUnitConfig config) {
        this.config = config;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(
                    config.getJdbcUrl(),
                    config.getDbUser(),
                    config.getDbPassword()
            );
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                throw new RuntimeException("Failed to close database connection", e);
            }
        }
    }

    public void setupDatabase() throws SQLException {
        try (var stmt = getConnection().createStatement()) {
            stmt.executeUpdate("DROP DATABASE IF EXISTS " + config.getDbName());
            stmt.executeUpdate("CREATE DATABASE " + config.getDbName());
            System.out.println("Database reset complete");
        }
    }
}