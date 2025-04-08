package com.github.diegopacheco.liquidunit.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class SQLRollbackParserTest {

    private SQLRollbackParser parser;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        parser = new SQLRollbackParser();
    }

    @Test
    void shouldExtractTableNamesWithBackticks() throws Exception {
        Path rollbackFile = createRollbackFile("""
                DROP TABLE IF EXISTS `user`;
                DROP TABLE `user_links`;
                """);

        Set<String> tableNames = parser.extractTableNamesFromRollback(rollbackFile);
        assertEquals(2, tableNames.size());
        assertTrue(tableNames.contains("user"));
        assertTrue(tableNames.contains("user_links"));
    }

    @Test
    void shouldHandleCaseInsensitivityForDropTable() throws Exception {
        Path rollbackFile = createRollbackFile("""
                drop table if exists profile.user;
                DROP TABLE profile.user_links;
                Drop Table profile.settings;
                """);

        Set<String> tableNames = parser.extractTableNamesFromRollback(rollbackFile);
        assertEquals(3, tableNames.size());
        assertTrue(tableNames.contains("profile.user"));
        assertTrue(tableNames.contains("profile.user_links"));
        assertTrue(tableNames.contains("profile.settings"));
    }

    @Test
    void shouldExtractSchemaNamesFromDropSchemaStatements() throws Exception {
        Path rollbackFile = createRollbackFile("""
                DROP SCHEMA IF EXISTS profile;
                DROP DATABASE test;
                DROP SCHEMA `analytics`;
                """);

        Set<String> schemaNames = parser.extractSchemaNamesFromRollback(rollbackFile);
        assertEquals(3, schemaNames.size());
        assertTrue(schemaNames.contains("profile"));
        assertTrue(schemaNames.contains("test"));
        assertTrue(schemaNames.contains("analytics"));
    }

    @Test
    void shouldHandleCaseInsensitivityForDropSchema() throws Exception {
        Path rollbackFile = createRollbackFile("""
                drop schema if exists profile;
                DROP DATABASE test;
                Drop Schema analytics;
                """);

        Set<String> schemaNames = parser.extractSchemaNamesFromRollback(rollbackFile);
        assertEquals(3, schemaNames.size());
        assertTrue(schemaNames.contains("profile"));
        assertTrue(schemaNames.contains("test"));
        assertTrue(schemaNames.contains("analytics"));
    }

    @Test
    void shouldHandleCaseInsensitivityForDeleteFrom() throws Exception {
        Path rollbackFile = createRollbackFile("""
                delete from profile.user;
                DELETE FROM profile.user_links;
                Delete From profile.settings;
                """);

        Map<String, String> deleteStatements = parser.extractDeleteStatements(rollbackFile);
        assertEquals(3, deleteStatements.size());
        assertTrue(deleteStatements.containsKey("profile.user"));
        assertTrue(deleteStatements.containsKey("profile.user_links"));
        assertTrue(deleteStatements.containsKey("profile.settings"));
    }

    @Test
    void shouldExtractDropColumnStatements() throws Exception {
        Path rollbackFile = createRollbackFile("""
            ALTER TABLE profile.user DROP COLUMN email;
            ALTER TABLE profile.user_links DROP COLUMN twitter_link;
            ALTER TABLE profile.settings DROP COLUMN theme;
            """);

        Map<String, List<String>> tableColumnsMap = parser.extractDropColumnStatements(rollbackFile);

        assertEquals(3, tableColumnsMap.size());  // Changed from 3 to 2
        assertTrue(tableColumnsMap.containsKey("profile.user"));
        assertTrue(tableColumnsMap.containsKey("profile.user_links"));
        assertEquals("email", tableColumnsMap.get("profile.user").getFirst());
        assertEquals("twitter_link", tableColumnsMap.get("profile.user_links").getFirst());
        assertEquals("theme", tableColumnsMap.get("profile.settings").getFirst());
    }

    @Test
    void shouldHandleMultipleColumnsForSameTable() throws Exception {
        Path rollbackFile = createRollbackFile("""
                ALTER TABLE profile.user DROP COLUMN email;
                ALTER TABLE profile.user DROP COLUMN phone;
                ALTER TABLE profile.user DROP COLUMN address;
                """);

        Map<String, List<String>> tableColumnsMap = parser.extractDropColumnStatements(rollbackFile);
        assertEquals(1, tableColumnsMap.size());
        List<String> columns = tableColumnsMap.get("profile.user");
        assertEquals(3, columns.size());
        assertTrue(columns.contains("email"));
        assertTrue(columns.contains("phone"));
        assertTrue(columns.contains("address"));
    }

    @Test
    void shouldHandleCaseInsensitivityForAlterTable() throws Exception {
        Path rollbackFile = createRollbackFile("""
                alter table profile.user drop column email;
                ALTER TABLE profile.user DROP COLUMN phone;
                Alter Table profile.user Drop Column address;
                """);

        Map<String, List<String>> tableColumnsMap = parser.extractDropColumnStatements(rollbackFile);

        assertEquals(1, tableColumnsMap.size());
        List<String> columns = tableColumnsMap.get("profile.user");
        assertEquals(3, columns.size());
        assertTrue(columns.contains("email"));
        assertTrue(columns.contains("phone"));
        assertTrue(columns.contains("address"));
    }

    @Test
    void shouldHandleMixedOperations() throws Exception {
        Path rollbackFile = createRollbackFile("""
                DROP TABLE IF EXISTS profile.temp;
                DELETE FROM profile.user WHERE active = false;
                ALTER TABLE profile.user_links DROP COLUMN twitter_link;
                DROP SCHEMA IF EXISTS analytics;
                """);

        // Test each extraction method
        Set<String> tableNames = parser.extractTableNamesFromRollback(rollbackFile);
        assertEquals(1, tableNames.size());
        assertTrue(tableNames.contains("profile.temp"));

        Set<String> schemaNames = parser.extractSchemaNamesFromRollback(rollbackFile);
        assertEquals(1, schemaNames.size());
        assertTrue(schemaNames.contains("analytics"));

        Map<String, String> deleteStatements = parser.extractDeleteStatements(rollbackFile);
        assertEquals(1, deleteStatements.size());
        assertTrue(deleteStatements.containsKey("profile.user"));

        Map<String, List<String>> tableColumnsMap = parser.extractDropColumnStatements(rollbackFile);
        assertEquals(1, tableColumnsMap.size());
        assertEquals("twitter_link", tableColumnsMap.get("profile.user_links").get(0));
    }

    @Test
    void shouldHandleEmptyFile() throws Exception {
        Path rollbackFile = createRollbackFile("");

        Set<String> tableNames = parser.extractTableNamesFromRollback(rollbackFile);
        Set<String> schemaNames = parser.extractSchemaNamesFromRollback(rollbackFile);
        Map<String, String> deleteStatements = parser.extractDeleteStatements(rollbackFile);
        Map<String, List<String>> tableColumnsMap = parser.extractDropColumnStatements(rollbackFile);

        assertTrue(tableNames.isEmpty());
        assertTrue(schemaNames.isEmpty());
        assertTrue(deleteStatements.isEmpty());
        assertTrue(tableColumnsMap.isEmpty());
    }

    @Test
    void shouldHandleNoMatchingStatements() throws Exception {
        Path rollbackFile = createRollbackFile("""
                SELECT * FROM profile.user;
                INSERT INTO profile.user (name) VALUES ('John');
                UPDATE profile.user SET active = true WHERE id = 1;
                """);

        Set<String> tableNames = parser.extractTableNamesFromRollback(rollbackFile);
        Set<String> schemaNames = parser.extractSchemaNamesFromRollback(rollbackFile);
        Map<String, String> deleteStatements = parser.extractDeleteStatements(rollbackFile);
        Map<String, List<String>> tableColumnsMap = parser.extractDropColumnStatements(rollbackFile);

        assertTrue(tableNames.isEmpty());
        assertTrue(schemaNames.isEmpty());
        assertTrue(deleteStatements.isEmpty());
        assertTrue(tableColumnsMap.isEmpty());
    }

    private Path createRollbackFile(String content) throws Exception {
        Path file = tempDir.resolve("rollback.sql");
        Files.writeString(file, content);
        return file;
    }
}