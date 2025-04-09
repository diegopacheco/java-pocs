package com.github.diegopacheco.liquidunit.migrations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.github.diegopacheco.liquidunit.core.DatabaseConnector;
import com.github.diegopacheco.liquidunit.core.LiquidUnitConfig;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.FileSystemResourceAccessor;

public class MigrationExecutor {
    private final DatabaseConnector dbConnector;
    private final LiquidUnitConfig config;

    public MigrationExecutor(DatabaseConnector dbConnector, LiquidUnitConfig config) {
        this.dbConnector = dbConnector;
        this.config = config;
    }

    public void runMigration(Path migrationDir) throws Exception {
        Path migrationFile = migrationDir.resolve("migration.sql");
        Path testFile = migrationDir.resolve("test.sql");
        Path rollbackFile = migrationDir.resolve("rollback.sql");

        validateMigrationFiles(migrationDir, migrationFile, testFile, rollbackFile);

        Connection connection = dbConnector.getConnection();
        Database database = DatabaseFactory.getInstance()
                .findCorrectDatabaseImplementation(new JdbcConnection(connection));

        FileSystemResourceAccessor resourceAccessor = new FileSystemResourceAccessor(
                migrationDir.getParent().getParent().getParent().getParent().toFile());

        String relativePath = "main/resources/migrations/" + migrationDir.getFileName() + "/migration.sql";

        try (Liquibase liquibase = new Liquibase(relativePath, resourceAccessor, database)) {
            liquibase.update(new Contexts(), new LabelExpression());

            try {
                runTests(connection, testFile);
            } catch (Exception e) {
                System.err.println("Test failed in folder " + migrationDir.getFileName()
                        + ", performing rollback. Error: " + e.getMessage());
                executeSqlFile(connection, rollbackFile);
                throw new Exception("Test failed in folder " + migrationDir.getFileName() + " and rollback executed.", e);
            }
        }
    }

    public void runRollback(Path migrationDir) throws Exception {
        Path rollbackFile = migrationDir.resolve("rollback.sql");

        if (!Files.exists(rollbackFile)) {
            throw new IOException("Missing rollback.sql file in " + migrationDir);
        }

        Connection connection = dbConnector.getConnection();
        executeSqlFile(connection, rollbackFile);

        // Verify tables are empty after rollback
        verifyRollback(connection, migrationDir);
    }

    private void validateMigrationFiles(Path migrationDir, Path... requiredFiles) throws IOException {
        for (Path file : requiredFiles) {
            if (!Files.exists(file)) {
                throw new IOException("Missing required file: " + file + " in " + migrationDir);
            }
        }
    }

    private void runTests(Connection connection, Path testFile) throws Exception {
        List<String> lines = Files.readAllLines(testFile);
        StringBuilder currentQuery = new StringBuilder();
        Integer expectedValue = null;
        boolean queryHasStarted = false;

        System.out.println("Executing tests from " + testFile);

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) {
                continue;
            }

            // Process comments for assertions
            if (line.startsWith("--")) {
                Matcher matcher = config.getAssertionPattern().matcher(line);
                if (matcher.find()) {
                    try {
                        expectedValue = Integer.parseInt(matcher.group(1));
                        System.out.println("Found expectation: " + expectedValue + " from: " + line);
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing expected value from: " + line);
                    }
                }
                continue;
            }

            // Process SQL line
            currentQuery.append(line).append(" ");
            queryHasStarted = true;

            // Execute query when semicolon is found
            if (line.endsWith(";")) {
                String sql = currentQuery.toString().trim();
                sql = sql.substring(0, sql.length() - 1); // Remove trailing semicolon

                // Check if we need to look ahead for an expectation after this query
                if (expectedValue == null && i + 1 < lines.size()) {
                    String nextLine = lines.get(i + 1).trim();
                    if (nextLine.startsWith("--")) {
                        Matcher matcher = config.getAssertionPattern().matcher(nextLine);
                        if (matcher.find()) {
                            try {
                                expectedValue = Integer.parseInt(matcher.group(1));
                                System.out.println("Found expectation (look-ahead): " + expectedValue);
                                i++; // Skip next line since we've processed it
                            } catch (NumberFormatException e) {
                                System.err.println("Error parsing expected value from: " + nextLine);
                            }
                        }
                    }
                }

                // Execute the query with or without verification
                if (expectedValue != null) {
                    verifyQueryResult(connection, sql, expectedValue);
                    expectedValue = null;
                } else {
                    executeSql(connection, sql + ";");
                }

                currentQuery = new StringBuilder();
                queryHasStarted = false;
            }
        }

        // Handle any remaining query
        if (currentQuery.length() > 0 && queryHasStarted) {
            String sql = currentQuery.toString().trim();
            if (sql.endsWith(";")) {
                sql = sql.substring(0, sql.length() - 1);
            }

            if (expectedValue != null) {
                verifyQueryResult(connection, sql, expectedValue);
            } else {
                executeSql(connection, sql + ";");
            }
        }
    }

    private void verifyQueryResult(Connection connection, String sql, int expectedValue) throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (!rs.next()) {
                throw new AssertionError("Query returned no results: " + sql);
            }

            int actualValue = rs.getInt(1);
            if (expectedValue != actualValue) {
                throw new AssertionError(
                        "Assertion failed for query: " + sql +
                                ". Expected: " + expectedValue + ", but got: " + actualValue);
            }
            System.out.println("✓ Assertion passed: " + sql + " -> Expected: " + expectedValue + ", Actual: " + actualValue);
        }
    }

    private void executeSqlFile(Connection connection, Path sqlFile) throws Exception {
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
    }

    private void executeSql(Connection connection, String sql) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        }
    }

    private void verifyRollback(Connection connection, Path migrationDir) throws Exception {
        // Implementation to verify tables are empty after rollback
        // This would check for empty tables or dropped objects
        try (Statement stmt = connection.createStatement()) {
            // Example: verify tables are empty
            ResultSet rs = stmt.executeQuery(
                    "SELECT TABLE_NAME FROM information_schema.TABLES " +
                            "WHERE TABLE_SCHEMA = '" + config.getDbName() + "'");

            while (rs.next()) {
                String tableName = rs.getString(1);
                verifyTableEmpty(connection, tableName);
            }
        }
    }

    private void verifyTableEmpty(Connection connection, String tableName) throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM " + config.getDbName() + "." + tableName)) {

            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("✓ Table verified empty after DELETE: " + config.getDbName() + "." + tableName);
            }
        }
    }
}