package com.bookstore.service;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bookstore.web.dto.SqlResponse;

@Service
public class SqlConsoleService {

    private final JdbcTemplate jdbc;

    public SqlConsoleService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public SqlResponse execute(String sql) {
        return jdbc.execute((java.sql.Connection connection) -> {
            try (Statement statement = connection.createStatement()) {
                boolean hasResultSet = statement.execute(sql);
                if (!hasResultSet) {
                    return new SqlResponse(List.of(), List.of(), 0, statement.getUpdateCount());
                }
                try (ResultSet rs = statement.getResultSet()) {
                    ResultSetMetaData meta = rs.getMetaData();
                    int columnCount = meta.getColumnCount();
                    List<String> columns = new ArrayList<>();
                    for (int i = 1; i <= columnCount; i++) {
                        columns.add(meta.getColumnName(i));
                    }
                    List<Map<String, Object>> rows = new ArrayList<>();
                    while (rs.next()) {
                        Map<String, Object> row = new LinkedHashMap<>();
                        for (int i = 1; i <= columnCount; i++) {
                            row.put(columns.get(i - 1), rs.getObject(i));
                        }
                        rows.add(row);
                    }
                    return new SqlResponse(columns, rows, rows.size(), null);
                }
            }
        });
    }
}
