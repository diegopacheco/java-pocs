package com.github.diegopacheco.liquidunit.parser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLTestsParser {

    // expect: <number>
    public static final Pattern ASSERTION_PATTERN =
            Pattern.compile("--\\s*(?:expect|expect:|expects|expected|result|returns|should" +
                        "|is|equals|equal|eq|==|count|value|val|check|assert)\\s*:?\\s*(\\d+)\\s*");

    public List<SQLAssertionPair> extractExpectedValues(Path testFile){
        try{
            List<SQLAssertionPair> expectedValues = new java.util.ArrayList<>();

            List<String> lines = Files.readAllLines(testFile);
            StringBuilder currentQuery = new StringBuilder();
            Integer expectedValue = null;
            boolean queryHasStarted = false;

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i).trim();
                if (line.isEmpty()) {
                    continue;
                }

                // Process comments for assertions
                if (line.startsWith("--")) {
                    Matcher matcher = SQLTestsParser.ASSERTION_PATTERN.matcher(line);
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
                            Matcher matcher = SQLTestsParser.ASSERTION_PATTERN.matcher(nextLine);
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

                    if (expectedValue != null) {
                        expectedValues.add(new SQLAssertionPair(sql, expectedValue));
                        expectedValue = null;
                    }
                    currentQuery = new StringBuilder();
                    queryHasStarted = false;
                }
            }

            // Handle any remaining query
            if (!currentQuery.isEmpty() && queryHasStarted) {
                String sql = currentQuery.toString().trim();
                if (sql.endsWith(";")) {
                    sql = sql.substring(0, sql.length() - 1);
                }

                if (expectedValue != null) {
                    expectedValues.add(new SQLAssertionPair(sql, expectedValue));
                }
            }

            return expectedValues;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
