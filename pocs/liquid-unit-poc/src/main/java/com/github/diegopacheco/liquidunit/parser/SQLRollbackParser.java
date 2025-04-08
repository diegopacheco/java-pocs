package com.github.diegopacheco.liquidunit.parser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLRollbackParser {

    public static final Pattern DROP_TABLE_PATTERN =
            Pattern.compile("DROP\\s+TABLE(?:\\s+IF\\s+EXISTS)?\\s+(?:`?([\\w.]+)`?)",
            Pattern.CASE_INSENSITIVE);

    public static final Pattern DROP_SCHEMA_PATTERN =
            Pattern.compile("DROP\\s+(?:DATABASE|SCHEMA)(?:\\s+IF\\s+EXISTS)?\\s+(?:`?([\\w.]+)`?)",
            Pattern.CASE_INSENSITIVE);

    public static final Pattern DELETE_FROM_PATTERN =
            Pattern.compile("DELETE\\s+FROM\\s+(?:`?([\\w.]+)`?)",
            Pattern.CASE_INSENSITIVE);

    public static final Pattern DROP_COLUMN_PATTERN =
            Pattern.compile("ALTER\\s+TABLE\\s+(?:`?([\\w.]+)`?)\\s+DROP\\s+(?:COLUMN\\s+)?(?:`?([\\w]+)`?)",
            Pattern.CASE_INSENSITIVE);

    public Set<String> extractTableNamesFromRollback(Path rollbackFile)  {
        try{
            Set<String> tableNames = new HashSet<>();
            List<String> lines = Files.readAllLines(rollbackFile);
            for (String line : lines) {
                Matcher matcher = SQLRollbackParser.DROP_TABLE_PATTERN.matcher(line);
                while (matcher.find()) {
                    tableNames.add(matcher.group(1).replace("`", ""));
                }
            }

            System.out.println("Tables to verify dropped: " + tableNames);
            return tableNames;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Set<String> extractSchemaNamesFromRollback(Path rollbackFile) {
        try{
            Set<String> schemaNames = new HashSet<>();
            List<String> lines = Files.readAllLines(rollbackFile);
            for (String line : lines) {
                Matcher matcher = SQLRollbackParser.DROP_SCHEMA_PATTERN.matcher(line);
                while (matcher.find()) {
                    schemaNames.add(matcher.group(1).replace("`", ""));
                }
            }

            System.out.println("Schemas to verify dropped: " + schemaNames);
            return schemaNames;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Map<String, String> extractDeleteStatements(Path rollbackFile) {
        try{
            Map<String, String> deletedTables = new HashMap<>();
            List<String> lines = Files.readAllLines(rollbackFile);
            for (String line : lines) {
                Matcher matcher = SQLRollbackParser.DELETE_FROM_PATTERN.matcher(line);
                while (matcher.find()) {
                    String tableName = matcher.group(1).replace("`", "");
                    deletedTables.put(tableName, line);
                }
            }

            System.out.println("Tables to verify empty after DELETE: " + deletedTables.keySet());
            return deletedTables;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Map<String, List<String>> extractDropColumnStatements(Path rollbackFile) {
        try{
            Map<String, List<String>> tableColumns = new HashMap<>();
            List<String> lines = Files.readAllLines(rollbackFile);

            for (String line : lines) {
                Matcher matcher = SQLRollbackParser.DROP_COLUMN_PATTERN.matcher(line);
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
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
