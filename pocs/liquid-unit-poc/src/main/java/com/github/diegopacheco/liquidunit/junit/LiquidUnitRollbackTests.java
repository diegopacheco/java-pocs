package com.github.diegopacheco.liquidunit.junit;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import com.github.diegopacheco.liquidunit.core.DatabaseConnector;
import com.github.diegopacheco.liquidunit.core.LiquidUnitConfig;
import com.github.diegopacheco.liquidunit.migrations.MigrationExecutor;
import com.github.diegopacheco.liquidunit.migrations.MigrationScanner;

public class LiquidUnitRollbackTests {
    private static final LiquidUnitConfig config = new LiquidUnitConfig();
    private static final DatabaseConnector dbConnector = new DatabaseConnector(config);
    private static final MigrationScanner scanner = new MigrationScanner("src/main/resources/migrations");
    private static final MigrationExecutor executor = new MigrationExecutor(dbConnector, config);

    @BeforeAll
    public static void setupDatabase() throws Exception {
        dbConnector.setupDatabase();
    }

    @AfterAll
    public static void closeDatabase() {
        dbConnector.closeConnection();
    }

    @TestFactory
    Collection<DynamicTest> runRollbacks() throws Exception {
        List<DynamicTest> dynamicTests = new ArrayList<>();

        List<Path> migrationDirs = scanner.scanMigrationDirectories();
        // Reverse the order for rollbacks
        for (int i = migrationDirs.size() - 1; i >= 0; i--) {
            Path migrationDir = migrationDirs.get(i);
            String testName = "Rollback " + migrationDir.getFileName().toString();
            dynamicTests.add(DynamicTest.dynamicTest(testName, () -> {
                executor.runRollback(migrationDir);
            }));
        }

        return dynamicTests;
    }
}