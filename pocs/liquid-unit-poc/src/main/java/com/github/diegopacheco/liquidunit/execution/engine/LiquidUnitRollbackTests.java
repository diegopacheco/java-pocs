package com.github.diegopacheco.liquidunit.execution.engine;

import com.github.diegopacheco.liquidunit.dao.DatabaseMigrationDAO;
import com.github.diegopacheco.liquidunit.liquibase.LiquibaseService;
import com.github.diegopacheco.liquidunit.parser.SQLRollbackParser;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class LiquidUnitRollbackTests {

    private final LiquibaseService liquibaseService = new LiquibaseService();
    private final SQLRollbackParser sqlRollbackParser = new SQLRollbackParser();
    private static final DatabaseMigrationDAO dao = new DatabaseMigrationDAO();

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

    private void verifyRollbackForMigration(Path migrationDir) {
        try {
            Path migrationFile = migrationDir.resolve("migration.sql");
            Path rollbackFile = migrationDir.resolve("rollback.sql");
            Connection connection = DatabaseMigrationDAO.getConnection();

            liquibaseService.runMigration(migrationDir);
            System.out.println("Applied migration: " + migrationDir.getFileName());

            // Extract items to verify from rollback.sql
            Set<String> tablesToVerify = sqlRollbackParser.extractTableNamesFromRollback(rollbackFile);
            Set<String> schemasToVerify = sqlRollbackParser.extractSchemaNamesFromRollback(rollbackFile);
            Map<String, String> deletedTableData = sqlRollbackParser.extractDeleteStatements(rollbackFile);
            Map<String, List<String>> droppedColumns = sqlRollbackParser.extractDropColumnStatements(rollbackFile);

            // Execute rollback.sql
            dao.executeSqlFile(rollbackFile);
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

    private void verifyTableDropped(Connection connection, String tableName) {
        // Split table name if it contains schema (schema.table)
        String table = tableName;
        if (tableName.contains(".")) {
            String[] parts = tableName.split("\\.");
            table = parts[1];
        }
        boolean tableExists = dao.tableExists(tableName);
        assertFalse(tableExists, "Table " + tableName + " still exists after rollback");
        System.out.println("✓ Table verified dropped: " + tableName);
    }

    private void verifySchemaDropped(Connection connection, String schemaName) {
        // Special case: don't try to verify if the main test DB is dropped
        if (dao.isSameSchema(schemaName)) {
            System.out.println("Skipping verification for main test database: " + schemaName);
            return;
        }
        boolean schemaExists = dao.schemaExists(schemaName);
        assertFalse(schemaExists, "Schema " + schemaName + " still exists after rollback");
        System.out.println("✓ Schema verified dropped: " + schemaName);
    }

    private void verifyTableIsEmpty(Connection connection, String tableName) {
        // Split table name if it contains schema (schema.table)
        String table = tableName;
        if (tableName.contains(".")) {
            String[] parts = tableName.split("\\.");
            table = parts[1];
        }
        boolean tableExists = dao.tableExists(tableName);
        if (!tableExists) {
            System.out.println("Table " + tableName + " doesn't exist, can't check if it's empty");
            return; // Table doesn't exist, can't verify it's empty
        }
        // Check if the table is empty
        boolean isEmpty = dao.isTableEmpty(tableName);
        assertTrue(isEmpty, "Table " + tableName + " still has data after DELETE");
        System.out.println("✓ Table verified empty after DELETE: " + tableName);
    }

    private void verifyColumnDropped(Connection connection, String tableName, String columnName) {
        // Split table name if it contains schema (schema.table)
        String table = tableName;
        if (tableName.contains(".")) {
            String[] parts = tableName.split("\\.");
            table = parts[1];
        }
        boolean columnExists = dao.columnExists(tableName, columnName);
        assertFalse(columnExists, "Column " + columnName + " in table " + tableName + " still exists after DROP");
        System.out.println("✓ Column verified dropped: " + columnName + " from table " + tableName);
    }

}