package com.github.diegopacheco.liquidunit;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.FileSystemResourceAccessor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class LiquidUnitRollbackTests {
    private static String MYSQL_HOST;
    private static int MYSQL_PORT;
    private static String MYSQL_DB;
    private static String MYSQL_USER;
    private static String MYSQL_PASSWORD;

    private static final Pattern DROP_TABLE_PATTERN = Pattern.compile("DROP\\s+TABLE(?:\\s+IF\\s+EXISTS)?\\s+(?:`?([\\w.]+)`?)", Pattern.CASE_INSENSITIVE);
    private static final Pattern DROP_SCHEMA_PATTERN = Pattern.compile("DROP\\s+(?:DATABASE|SCHEMA)(?:\\s+IF\\s+EXISTS)?\\s+(?:`?([\\w.]+)`?)", Pattern.CASE_INSENSITIVE);
    private static final Pattern DELETE_FROM_PATTERN = Pattern.compile("DELETE\\s+FROM\\s+(?:`?([\\w.]+)`?)", Pattern.CASE_INSENSITIVE);
    private static final Pattern DROP_COLUMN_PATTERN = Pattern.compile("ALTER\\s+TABLE\\s+(?:`?([\\w.]+)`?)\\s+DROP\\s+(?:COLUMN\\s+)?(?:`?([\\w]+)`?)", Pattern.CASE_INSENSITIVE);

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
        if (null == conn || conn.isClosed()) {
            String url = String.format("jdbc:mysql://%s:%d/%s", MYSQL_HOST, MYSQL_PORT, MYSQL_DB);
            conn = DriverManager.getConnection(url, MYSQL_USER, MYSQL_PASSWORD);
        }
        return conn;
    }

    @AfterAll
    public static void closeDatabase() throws Exception {
        Connection conn = getConnection();
        try (Statement stmt = conn.createStatement()) {
            //stmt.execute("DROP TABLE IF EXISTS DATABASECHANGELOG;");
            //stmt.execute("DROP TABLE IF EXISTS DATABASECHANGELOGLOCK;");
            stmt.execute("COMMIT;");
            System.out.println("Liquibase database reset complete");
        }

        if (null!=conn && !conn.isClosed()) {
            conn.close();
        }
    }

    @TestFactory
    Collection<DynamicTest> verifyRollbacks() throws Exception {
        Path basePath = Paths.get("src/main/resources/migrations");
        if (!Files.exists(basePath)) {
            fail("Migrations folder not found: " + basePath.toAbsolutePath());
        }

        List<DynamicTest> dynamicTests = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(basePath, 1)) {
            // Collect paths and then reverse them
            List<Path> migrationPaths = paths
                    .filter(Files::isDirectory)
                    .filter(path -> !path.equals(basePath)) // exclude the base folder
                    .sorted() // sort for a consistent order
                    .collect(Collectors.toList());

            // Reverse the order to process from newest to oldest
            Collections.reverse(migrationPaths);

            migrationPaths.forEach(migrationDir -> {
                String testName = migrationDir.getFileName().toString() + " - Rollback";
                dynamicTests.add(DynamicTest.dynamicTest(testName, () -> {
                    verifyRollbackForMigration(migrationDir);
                }));
            });
        }

        // Add a final test to run all the normal tests after rollback verification
        dynamicTests.add(DynamicTest.dynamicTest("Run LiquidUnitTests after rollbacks", () -> {
            LiquidUnitTests tests = new LiquidUnitTests();
            tests.runMigrations();
        }));

        return dynamicTests;
    }

    private void verifyRollbackForMigration(Path migrationDir) throws Exception {
        Path migrationFile = migrationDir.resolve("migration.sql");
        Path rollbackFile = migrationDir.resolve("rollback.sql");

        if (!Files.exists(migrationFile) || !Files.exists(rollbackFile)) {
            throw new IOException("Missing required SQL files in " + migrationDir);
        }

        Connection connection = getConnection();
        try {
            // First apply the migration
            Database database = DatabaseFactory.getInstance()
                    .findCorrectDatabaseImplementation(new JdbcConnection(connection));
            FileSystemResourceAccessor resourceAccessor = new FileSystemResourceAccessor(
                    migrationDir.getParent().getParent().getParent().getParent().toFile());

            String relativePath = "main/resources/migrations/" + migrationDir.getFileName() + "/migration.sql";
            Liquibase liquibase = new Liquibase(relativePath, resourceAccessor, database);
            liquibase.update(new Contexts(), new LabelExpression());

            System.out.println("Applied migration: " + migrationDir.getFileName());

            // Extract items to verify from rollback.sql
            Set<String> tablesToVerify = extractTableNamesFromRollback(rollbackFile);
            Set<String> schemasToVerify = extractSchemaNamesFromRollback(rollbackFile);
            Map<String, String> deletedTableData = extractDeleteStatements(rollbackFile);
            Map<String, List<String>> droppedColumns = extractDropColumnStatements(rollbackFile);

            // Execute rollback.sql
            executeSqlFile(connection, rollbackFile);
            System.out.println("Executed rollback: " + rollbackFile);

            // Verify tables are dropped
            for (String tableName : tablesToVerify) {
                verifyTableDropped(connection, tableName);
            }

            // Verify schemas are dropped
            for (String schemaName : schemasToVerify) {
                verifySchemaDropped(connection, schemaName);
            }

            // Verify data is deleted (tables are empty)
            for (Map.Entry<String, String> entry : deletedTableData.entrySet()) {
                verifyTableIsEmpty(connection, entry.getKey());
            }

            // Verify columns are dropped
            for (Map.Entry<String, List<String>> entry : droppedColumns.entrySet()) {
                for (String column : entry.getValue()) {
                    verifyColumnDropped(connection, entry.getKey(), column);
                }
            }
        } catch (Exception e) {
            System.err.println("Rollback verification failed for " + migrationDir.getFileName() + ": " + e.getMessage());
            throw e;
        }
    }

    private Set<String> extractTableNamesFromRollback(Path rollbackFile) throws IOException {
        Set<String> tableNames = new HashSet<>();
        List<String> lines = Files.readAllLines(rollbackFile);

        for (String line : lines) {
            Matcher matcher = DROP_TABLE_PATTERN.matcher(line);
            while (matcher.find()) {
                tableNames.add(matcher.group(1).replace("`", ""));
            }
        }

        System.out.println("Tables to verify dropped: " + tableNames);
        return tableNames;
    }

    private Set<String> extractSchemaNamesFromRollback(Path rollbackFile) throws IOException {
        Set<String> schemaNames = new HashSet<>();
        List<String> lines = Files.readAllLines(rollbackFile);

        for (String line : lines) {
            Matcher matcher = DROP_SCHEMA_PATTERN.matcher(line);
            while (matcher.find()) {
                schemaNames.add(matcher.group(1).replace("`", ""));
            }
        }

        System.out.println("Schemas to verify dropped: " + schemaNames);
        return schemaNames;
    }

    private Map<String, String> extractDeleteStatements(Path rollbackFile) throws IOException {
        Map<String, String> deletedTables = new HashMap<>();
        List<String> lines = Files.readAllLines(rollbackFile);

        for (String line : lines) {
            Matcher matcher = DELETE_FROM_PATTERN.matcher(line);
            while (matcher.find()) {
                String tableName = matcher.group(1).replace("`", "");
                deletedTables.put(tableName, line);
            }
        }

        System.out.println("Tables to verify empty after DELETE: " + deletedTables.keySet());
        return deletedTables;
    }

    private Map<String, List<String>> extractDropColumnStatements(Path rollbackFile) throws IOException {
        Map<String, List<String>> tableColumns = new HashMap<>();
        List<String> lines = Files.readAllLines(rollbackFile);

        for (String line : lines) {
            Matcher matcher = DROP_COLUMN_PATTERN.matcher(line);
            while (matcher.find()) {
                String tableName = matcher.group(1).replace("`", "");
                String columnName = matcher.group(2).replace("`", "");

                tableColumns.computeIfAbsent(tableName, k -> new ArrayList<>()).add(columnName);
            }
        }

        for (Map.Entry<String, List<String>> entry : tableColumns.entrySet()) {
            System.out.println("Columns to verify dropped from " + entry.getKey() + ": " + entry.getValue());
        }

        return tableColumns;
    }

    private void verifyTableDropped(Connection connection, String tableName) throws SQLException {
        // Split table name if it contains schema (schema.table)
        String schema = MYSQL_DB;
        String table = tableName;
        if (tableName.contains(".")) {
            String[] parts = tableName.split("\\.");
            schema = parts[0];
            table = parts[1];
        }

        // Query information_schema to check if table exists
        try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT COUNT(*) FROM information_schema.tables " +
                        "WHERE table_schema = ? AND table_name = ?")) {
            stmt.setString(1, schema);
            stmt.setString(2, table);

            try (ResultSet rs = stmt.executeQuery()) {
                assertTrue(rs.next());
                int count = rs.getInt(1);
                assertEquals(0, count, "Table " + tableName + " still exists after rollback");
                System.out.println("✓ Table verified dropped: " + tableName);
            }
        }
    }

    private void verifySchemaDropped(Connection connection, String schemaName) throws SQLException {
        // Special case: don't try to verify if the main test DB is dropped
        if (schemaName.equalsIgnoreCase(MYSQL_DB)) {
            System.out.println("Skipping verification for main test database: " + schemaName);
            return;
        }

        // Query information_schema to check if schema exists
        try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT COUNT(*) FROM information_schema.schemata WHERE schema_name = ?")) {
            stmt.setString(1, schemaName);

            try (ResultSet rs = stmt.executeQuery()) {
                assertTrue(rs.next());
                int count = rs.getInt(1);
                assertEquals(0, count, "Schema " + schemaName + " still exists after rollback");
                System.out.println("✓ Schema verified dropped: " + schemaName);
            }
        }
    }

    private void verifyTableIsEmpty(Connection connection, String tableName) throws SQLException {
        // Split table name if it contains schema (schema.table)
        String schema = MYSQL_DB;
        String table = tableName;
        if (tableName.contains(".")) {
            String[] parts = tableName.split("\\.");
            schema = parts[0];
            table = parts[1];
        }

        // First check if the table exists
        try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT COUNT(*) FROM information_schema.tables " +
                        "WHERE table_schema = ? AND table_name = ?")) {
            stmt.setString(1, schema);
            stmt.setString(2, table);

            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.next() || rs.getInt(1) == 0) {
                    System.out.println("Table " + tableName + " doesn't exist, can't check if it's empty");
                    return; // Table doesn't exist, can't verify it's empty
                }
            }
        }

        // Check if the table is empty
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM " + tableName)) {
            assertTrue(rs.next());
            int count = rs.getInt(1);
            assertEquals(0, count, "Table " + tableName + " still has data after DELETE");
            System.out.println("✓ Table verified empty after DELETE: " + tableName);
        }
    }

    private void verifyColumnDropped(Connection connection, String tableName, String columnName) throws SQLException {
        // Split table name if it contains schema (schema.table)
        String schema = MYSQL_DB;
        String table = tableName;
        if (tableName.contains(".")) {
            String[] parts = tableName.split("\\.");
            schema = parts[0];
            table = parts[1];
        }

        // Query information_schema to check if column exists
        try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT COUNT(*) FROM information_schema.columns " +
                        "WHERE table_schema = ? AND table_name = ? AND column_name = ?")) {
            stmt.setString(1, schema);
            stmt.setString(2, table);
            stmt.setString(3, columnName);

            try (ResultSet rs = stmt.executeQuery()) {
                assertTrue(rs.next());
                int count = rs.getInt(1);
                assertEquals(0, count, "Column " + columnName + " in table " + tableName + " still exists after DROP");
                System.out.println("✓ Column verified dropped: " + columnName + " from table " + tableName);
            }
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
}