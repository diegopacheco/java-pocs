package com.github.diegopacheco.liquidunit.execution.engine;

import com.github.diegopacheco.liquidunit.dao.DatabaseMigrationDAO;
import com.github.diegopacheco.liquidunit.liquibase.LiquibaseService;
import com.github.diegopacheco.liquidunit.parser.SQLAssertionPair;
import com.github.diegopacheco.liquidunit.parser.SQLTestsParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class LiquidUnitTests {

    private final LiquibaseService liquibaseService = new LiquibaseService();
    private final SQLTestsParser sqlTestsParser = new SQLTestsParser();
    private static final DatabaseMigrationDAO dao = new DatabaseMigrationDAO();

    @BeforeAll
    public static void setupDatabase() throws Exception {
        dao.cleanupDatabase();
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
        liquibaseService.runMigration(migrationDir);
        Path testFile = migrationDir.resolve("test.sql");
        Path rollbackFile = migrationDir.resolve("rollback.sql");
        try {
            Connection connection = DatabaseMigrationDAO.getConnection();
            executeAndVerifyTests(connection, testFile);
        } catch (Exception e) {
            System.err.println("Test failed in folder " + migrationDir.getFileName()
                    + ", performing rollback. Error: " + e.getMessage());
            dao.executeSqlFile(rollbackFile);
            throw new Exception("Test failed in folder " + migrationDir.getFileName() + " and rollback executed.", e);
        }
    }

    private void executeAndVerifyTests(Connection connection, Path testFile) {
        try{
            System.out.println("Executing tests from " + testFile);
            List<SQLAssertionPair> expectedValues = sqlTestsParser.extractExpectedValues(testFile);
            for(SQLAssertionPair pair : expectedValues) {
                verifyQueryResult(pair.sql(), pair.expectedValue());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void verifyQueryResult(String sql, int expectedValue) {
            int actualValue = dao.queryForInt(sql);
            assertEquals(expectedValue, actualValue,
                    "Assertion failed for query: " + sql +
                           ". Expected: " + expectedValue + ", but got: " + actualValue);
            System.out.println("✓ Assertion passed: " + sql +
                           " -> Expected: " + expectedValue + ", Actual: " + actualValue);
    }
}