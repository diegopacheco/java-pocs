package com.diegopacheco.pgrustfun.sql;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SqlConsoleService {

    private final JdbcTemplate jdbcTemplate;

    public SqlConsoleService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SqlQueryResponse execute(String sql) {
        String statement = normalize(sql);
        return jdbcTemplate.execute((ConnectionCallback<SqlQueryResponse>) connection -> {
            try (Statement jdbcStatement = connection.createStatement()) {
                boolean resultSetPresent = jdbcStatement.execute(statement);
                if (!resultSetPresent) {
                    return new SqlQueryResponse(List.of(), List.of(), jdbcStatement.getUpdateCount());
                }
                try (ResultSet resultSet = jdbcStatement.getResultSet()) {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    List<String> columns = new ArrayList<>();
                    for (int columnIndex = 1; columnIndex <= metaData.getColumnCount(); columnIndex++) {
                        columns.add(metaData.getColumnLabel(columnIndex));
                    }
                    List<Map<String, Object>> rows = new ArrayList<>();
                    while (resultSet.next()) {
                        Map<String, Object> row = new LinkedHashMap<>();
                        for (String column : columns) {
                            row.put(column, resultSet.getObject(column));
                        }
                        rows.add(row);
                    }
                    return new SqlQueryResponse(columns, rows, null);
                }
            }
        });
    }

    public List<SqlTableInfo> tables() {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("""
                select table_name, column_name, ordinal_position
                from information_schema.columns
                where table_schema = 'public'
                order by table_name, ordinal_position
                """);
        Map<String, List<String>> grouped = new LinkedHashMap<>();
        for (Map<String, Object> row : rows) {
            String tableName = String.valueOf(row.get("table_name"));
            String columnName = String.valueOf(row.get("column_name"));
            grouped.computeIfAbsent(tableName, ignored -> new ArrayList<>()).add(columnName);
        }
        return grouped.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .map(entry -> new SqlTableInfo(entry.getKey(), List.copyOf(entry.getValue())))
                .collect(Collectors.toList());
    }

    private String normalize(String sql) {
        if (!StringUtils.hasText(sql)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "sql is required");
        }
        String normalized = sql.trim();
        while (normalized.endsWith(";")) {
            normalized = normalized.substring(0, normalized.length() - 1).trim();
        }
        if (!StringUtils.hasText(normalized)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "sql is required");
        }
        if (normalized.contains(";")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Only one SQL statement is allowed");
        }
        return normalized;
    }
}
