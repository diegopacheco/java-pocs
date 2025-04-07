package com.github.diegopacheco.liquidunit;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.FileSystemResourceAccessor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class LiquidUnitTests {

    private static String MYSQL_HOST;
    private static int MYSQL_PORT;
    private static String MYSQL_DB;
    private static String MYSQL_USER;
    private static String MYSQL_PASSWORD;

    // expect: <number>
    private static final Pattern ASSERTION_PATTERN = Pattern.compile("--\\s*(?:expect|expect:|expects|expected|result|returns|should|is|equals|equal|eq|==|count|value|val|check|assert)\\s*:?\\s*(\\d+)\\s*");

    private static Connection conn = null;

    static {
        try {
            Properties properties = new Properties();
            FileInputStream input = new FileInputStream("src/main/resources/application.properties");
            properties.load(input);
            input.close();
            MYSQL_HOST = properties.getProperty("db.host", "127.0.0.1");
            MYSQL_PORT = Integer.parseInt(properties.getProperty("db.port", "3306"));
            MYSQL_DB = properties.getProperty("db.database", "profile");
            MYSQL_USER = properties.getProperty("db.user", "root");
            MYSQL_PASSWORD = properties.getProperty("db.password", "pass");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection getConnection() throws Exception {
        if (null==conn) {
            String url = String.format("jdbc:mysql://%s:%d/%s", MYSQL_HOST, MYSQL_PORT, MYSQL_DB);
            conn = DriverManager.getConnection(url, MYSQL_USER, MYSQL_PASSWORD);
        }
        return conn;
    }

    @BeforeAll
    public static void setupDatabase() throws Exception {
        Connection conn = getConnection();
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DROP DATABASE IF EXISTS " + MYSQL_DB);
            stmt.executeUpdate("CREATE DATABASE " + MYSQL_DB);
            System.out.println("Database reset complete");
        }
    }

    @AfterAll
    public static void closeDatabase() throws Exception {
        if (null!=conn) {
            conn.close();
        }
    }

    @TestFactory
    Collection<DynamicTest> runMigrations() throws Exception {
        Path basePath = Paths.get("src/main/resources/migrations");
        if (!Files.exists(basePath)) {
            fail("Migrations folder not found: " + basePath.toAbsolutePath());
        }

        List<DynamicTest> dynamicTests = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(basePath, 1)) {
            paths.filter(Files::isDirectory)
                    .filter(path -> !path.equals(basePath)) // exclude the base folder
                    .sorted() // sort for a consistent order
                    .forEach(migrationDir -> {
                        String testName = migrationDir.getFileName().toString();
                        dynamicTests.add(DynamicTest.dynamicTest(testName, () -> {
                            runMigrationSet(migrationDir);
                        }));
                    });
        }

        return dynamicTests;
    }

    private void runMigrationSet(Path migrationDir) throws Exception {
        Path migrationFile = migrationDir.resolve("migration.sql");
        Path testFile = migrationDir.resolve("test.sql");
        Path rollbackFile = migrationDir.resolve("rollback.sql");

        if (!Files.exists(migrationFile) || !Files.exists(testFile) || !Files.exists(rollbackFile)) {
            throw new IOException("Missing one of the required SQL files in " + migrationDir);
        }

        Connection connection = getConnection();
        try {
            Database database = DatabaseFactory.getInstance()
                    .findCorrectDatabaseImplementation(new JdbcConnection(connection));
            FileSystemResourceAccessor resourceAccessor = new FileSystemResourceAccessor(
                    migrationDir.getParent().getParent().getParent().getParent().toFile());

            String relativePath = "main/resources/migrations/" + migrationDir.getFileName() + "/migration.sql";
            Liquibase liquibase = new Liquibase(relativePath, resourceAccessor, database);
            liquibase.update(new Contexts(), new LabelExpression());

            try {
                executeAndVerifyTests(connection, testFile);
            } catch (Exception e) {
                System.err.println("Test failed in folder " + migrationDir.getFileName()
                        + ", performing rollback. Error: " + e.getMessage());
                executeSqlFile(connection, rollbackFile);
                throw new Exception("Test failed in folder " + migrationDir.getFileName() + " and rollback executed.", e);
            }
        } finally {}
    }

    private void executeAndVerifyTests(Connection connection, Path testFile) throws Exception {
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
                Matcher matcher = ASSERTION_PATTERN.matcher(line);
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
                        Matcher matcher = ASSERTION_PATTERN.matcher(nextLine);
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

            assertTrue(rs.next(), "Query returned no results: " + sql);
            int actualValue = rs.getInt(1);
            assertEquals(expectedValue, actualValue,
                    "Assertion failed for query: " + sql +
                            ". Expected: " + expectedValue + ", but got: " + actualValue);
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
}