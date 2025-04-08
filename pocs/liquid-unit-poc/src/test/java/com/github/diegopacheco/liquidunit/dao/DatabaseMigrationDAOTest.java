package com.github.diegopacheco.liquidunit.dao;

import org.junit.jupiter.api.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.*;

@Order(0)
class DatabaseMigrationDAOIntegrationTest {

    private DatabaseMigrationDAO dao;
    private static final String TEST_SCHEMA = "profile";
    private static final String TEST_TABLE = "test_table";
    private static final String TEST_COLUMN = "test_column";

    @BeforeEach
    void setUp() {
        dao = new DatabaseMigrationDAO();
        dao.executeSql("CREATE TABLE IF NOT EXISTS " + TEST_SCHEMA + "." + TEST_TABLE +
                "(" + TEST_COLUMN + " VARCHAR(255))");
    }

    @Test
    void getConnection_shouldReturnValidConnection() {
        Connection connection = DatabaseMigrationDAO.getConnection();
        assertNotNull(connection, "Connection should not be null");
    }

    @Test
    void executeSql_shouldExecuteValidSql() {
        dao.executeSql("DELETE FROM " + TEST_SCHEMA + "." + TEST_TABLE);

        dao.executeSql("INSERT INTO " + TEST_SCHEMA + "." + TEST_TABLE +
                " (" + TEST_COLUMN + ") VALUES ('test_value')");

        int count = dao.queryForInt("SELECT COUNT(*) FROM " + TEST_SCHEMA + "." + TEST_TABLE);
        assertEquals(1, count, "Table should have one row after insertion");
    }

    @Test
    void executeSqlFile_shouldExecuteSqlFromFile() throws Exception {
        Path tempFile = Files.createTempFile("test-sql", ".sql");
        Files.writeString(tempFile, "DELETE FROM " + TEST_SCHEMA + "." + TEST_TABLE + ";" +
                "INSERT INTO " + TEST_SCHEMA + "." + TEST_TABLE + " (" + TEST_COLUMN + ") VALUES ('file_test');");

        dao.executeSqlFile(tempFile);

        int count = dao.queryForInt("SELECT COUNT(*) FROM " + TEST_SCHEMA + "." + TEST_TABLE +
                " WHERE " + TEST_COLUMN + " = 'file_test'");
        assertEquals(1, count, "Table should have one row with the expected value");

        Files.deleteIfExists(tempFile);
    }

    @Test
    void isTableEmpty_shouldReturnTrueForEmptyTable() {
        dao.executeSql("DELETE FROM " + TEST_SCHEMA + "." + TEST_TABLE);

        assertTrue(dao.isTableEmpty(TEST_TABLE), "Table should be empty after deletion");

        dao.executeSql("INSERT INTO " + TEST_SCHEMA + "." + TEST_TABLE +
                " (" + TEST_COLUMN + ") VALUES ('test_value')");
        assertFalse(dao.isTableEmpty(TEST_TABLE), "Table should not be empty after insertion");
    }

    @Test
    void schemaExists_shouldReturnTrueForExistingSchema() {
        assertTrue(dao.schemaExists(TEST_SCHEMA), "Test schema should exist");
        assertFalse(dao.schemaExists("non_existing_schema"), "Non-existing schema should return false");
    }

    @Test
    void tableExists_shouldReturnTrueForExistingTable() {
        assertTrue(dao.tableExists(TEST_TABLE), "Test table should exist");
        assertFalse(dao.tableExists("non_existing_table"), "Non-existing table should return false");
    }

    @Test
    void columnExists_shouldReturnTrueForExistingColumn() {
        assertTrue(dao.columnExists(TEST_TABLE, TEST_COLUMN), "Test column should exist");
        assertFalse(dao.columnExists(TEST_TABLE, "non_existing_column"),
                "Non-existing column should return false");
    }

    @Test
    void isSameSchema_shouldReturnTrueForMatchingSchema() {
        assertTrue(dao.isSameSchema(TEST_SCHEMA), "Schema name should match");
        assertFalse(dao.isSameSchema("other_schema"), "Different schema name should not match");
    }

    @Test
    void queryForInt_shouldReturnExpectedValue() {
        dao.executeSql("DELETE FROM " + TEST_SCHEMA + "." + TEST_TABLE);
        dao.executeSql("INSERT INTO " + TEST_SCHEMA + "." + TEST_TABLE +
                " (" + TEST_COLUMN + ") VALUES ('val1'),('val2'),('val3')");

        assertEquals(3, dao.queryForInt("SELECT COUNT(*) FROM " + TEST_SCHEMA + "." + TEST_TABLE),
                "Should return correct row count");
    }

    @AfterAll
    static void tearDown() {
        DatabaseMigrationDAO dao = new DatabaseMigrationDAO();
        dao.executeSql("DROP TABLE IF EXISTS " + TEST_SCHEMA + "." + TEST_TABLE);
    }
}