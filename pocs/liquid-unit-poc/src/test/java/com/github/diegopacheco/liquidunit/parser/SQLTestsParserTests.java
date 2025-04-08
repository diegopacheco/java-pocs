package com.github.diegopacheco.liquidunit.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SQLTestsParserTests {

    private SQLTestsParser parser;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        parser = new SQLTestsParser();
    }

    @Test
    void shouldExtractSingleExpectationAtBeginning() throws Exception {
        Path testFile = createTestFile("""
                -- expect: 10
                SELECT COUNT(*) FROM profile.user;
                """);

        List<SQLAssertionPair> assertions = parser.extractExpectedValues(testFile);
        assertEquals(1, assertions.size());
        assertEquals("SELECT COUNT(*) FROM profile.user", assertions.get(0).sql());
        assertEquals(10, assertions.get(0).expectedValue());
    }

    @Test
    void shouldExtractSingleExpectationAtEnd() throws Exception {
        Path testFile = createTestFile("""
                SELECT COUNT(*) FROM profile.user;
                -- expect: 10
                """);

        List<SQLAssertionPair> assertions = parser.extractExpectedValues(testFile);
        assertEquals(1, assertions.size());
        assertEquals("SELECT COUNT(*) FROM profile.user", assertions.getFirst().sql());
        assertEquals(10, assertions.getFirst().expectedValue());
    }

    @Test
    void shouldExtractMultipleExpectations() throws Exception {
        Path testFile = createTestFile("""
                -- expect: 10
                SELECT COUNT(*) FROM profile.user;
                
                -- expect: 5
                SELECT COUNT(*) FROM profile.user WHERE active = true;
                """);

        List<SQLAssertionPair> assertions = parser.extractExpectedValues(testFile);
        assertEquals(2, assertions.size());
        assertEquals("SELECT COUNT(*) FROM profile.user", assertions.get(0).sql());
        assertEquals(10, assertions.get(0).expectedValue());
        assertEquals("SELECT COUNT(*) FROM profile.user WHERE active = true", assertions.get(1).sql());
        assertEquals(5, assertions.get(1).expectedValue());
    }

    @Test
    void shouldHandleMultilineQueries() throws Exception {
        Path testFile = createTestFile("""
                -- expect: 3
                SELECT COUNT(*)
                FROM profile.user
                WHERE name = 'John'
                AND active = true;
                """);

        List<SQLAssertionPair> assertions = parser.extractExpectedValues(testFile);
        assertEquals(1, assertions.size());
        assertEquals("SELECT COUNT(*) FROM profile.user WHERE name = 'John' AND active = true", assertions.get(0).sql());
        assertEquals(3, assertions.getFirst().expectedValue());
    }

    @Test
    void shouldHandleVariousExpectationFormats() throws Exception {
        Path testFile = createTestFile("""
                -- expect: 10
                SELECT COUNT(*) FROM table1;
                
                -- expects: 20
                SELECT COUNT(*) FROM table2;
                
                -- expected: 30
                SELECT COUNT(*) FROM table3;
                
                -- result: 40
                SELECT COUNT(*) FROM table4;
                
                -- returns: 50
                SELECT COUNT(*) FROM table5;
                
                -- should: 60
                SELECT COUNT(*) FROM table6;
                
                -- is: 70
                SELECT COUNT(*) FROM table7;
                
                -- equals: 80
                SELECT COUNT(*) FROM table8;
                
                -- equal: 90
                SELECT COUNT(*) FROM table9;
                
                -- eq: 100
                SELECT COUNT(*) FROM table10;
                
                -- ==: 110
                SELECT COUNT(*) FROM table11;
                
                -- count: 120
                SELECT * FROM table12;
                """);

        List<SQLAssertionPair> assertions = parser.extractExpectedValues(testFile);

        assertEquals(12, assertions.size());
        assertEquals(10, assertions.get(0).expectedValue());
        assertEquals(20, assertions.get(1).expectedValue());
        assertEquals(30, assertions.get(2).expectedValue());
        assertEquals(40, assertions.get(3).expectedValue());
        assertEquals(50, assertions.get(4).expectedValue());
        assertEquals(60, assertions.get(5).expectedValue());
        assertEquals(70, assertions.get(6).expectedValue());
        assertEquals(80, assertions.get(7).expectedValue());
        assertEquals(90, assertions.get(8).expectedValue());
        assertEquals(100, assertions.get(9).expectedValue());
        assertEquals(110, assertions.get(10).expectedValue());
        assertEquals(120, assertions.get(11).expectedValue());
    }

    @Test
    void shouldHandleEmptyFile() throws Exception {
        Path testFile = createTestFile("");
        List<SQLAssertionPair> assertions = parser.extractExpectedValues(testFile);
        assertTrue(assertions.isEmpty());
    }

    @Test
    void shouldHandleSQLWithoutExpectations() throws Exception {
        Path testFile = createTestFile("""
                SELECT * FROM table1;
                SELECT COUNT(*) FROM table2;
                """);

        List<SQLAssertionPair> assertions = parser.extractExpectedValues(testFile);
        assertTrue(assertions.isEmpty());
    }

    @Test
    void shouldHandleCommentsWithoutExpectations() throws Exception {
        Path testFile = createTestFile("""
                -- This is just a comment
                SELECT * FROM table1;
                -- Another comment
                SELECT COUNT(*) FROM table2;
                """);

        List<SQLAssertionPair> assertions = parser.extractExpectedValues(testFile);
        assertTrue(assertions.isEmpty());
    }

    @Test
    void shouldHandleInvalidExpectationFormats() throws Exception {
        Path testFile = createTestFile("""
                -- expect: not_a_number
                SELECT * FROM table1;
                
                -- expect: 10
                SELECT * FROM table2;
                """);

        List<SQLAssertionPair> assertions = parser.extractExpectedValues(testFile);
        assertEquals(1, assertions.size());
        assertEquals("SELECT * FROM table2", assertions.get(0).sql());
        assertEquals(10, assertions.get(0).expectedValue());
    }

    @Test
    void shouldHandleComplexScenario() throws Exception {
        Path testFile = createTestFile("""
                -- This test checks various tables
                
                -- expect: 10
                SELECT COUNT(*) 
                FROM profile.user 
                WHERE active = true;
                
                -- Just a comment in between
                
                SELECT * FROM some_table; -- No expectation for this
                
                -- equals: 5
                SELECT COUNT(*) FROM profile.user_links;
                
                -- Complex query below
                -- expect: 3
                SELECT COUNT(DISTINCT u.id) 
                FROM profile.user u 
                JOIN profile.user_links x ON u.id = x.user_id 
                  AND x.x_link IS NOT NULL 
                JOIN profile.user_links fb ON u.id = fb.user_id 
                  AND fb.facebook_link IS NOT NULL;
                """);

        List<SQLAssertionPair> assertions = parser.extractExpectedValues(testFile);

        assertEquals(3, assertions.size());
        assertEquals(10, assertions.get(0).expectedValue());
        assertEquals(5, assertions.get(1).expectedValue());
        assertEquals(3, assertions.get(2).expectedValue());
        assertTrue(assertions.get(2).sql().contains("SELECT COUNT(DISTINCT u.id)"));
        assertTrue(assertions.get(2).sql().contains("JOIN profile.user_links fb"));
    }

    @Test
    void shouldHandleQueriesWithoutSemicolon() throws Exception {
        Path testFile = createTestFile("""
                -- expect: 10
                SELECT COUNT(*) FROM profile.user
                """);

        List<SQLAssertionPair> assertions = parser.extractExpectedValues(testFile);
        assertEquals(1, assertions.size());
        assertEquals("SELECT COUNT(*) FROM profile.user", assertions.get(0).sql());
        assertEquals(10, assertions.get(0).expectedValue());
    }

    private Path createTestFile(String content) throws Exception {
        Path file = tempDir.resolve("test.sql");
        Files.writeString(file, content);
        return file;
    }
}