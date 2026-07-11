package com.bookstore.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.service.SqlConsoleService;
import com.bookstore.web.dto.SqlRequest;
import com.bookstore.web.dto.SqlResponse;
import com.bookstore.web.dto.TableSchema;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/sql")
@Tag(name = "SQL Console")
public class SqlConsoleController {

    private final SqlConsoleService sqlConsoleService;

    public SqlConsoleController(SqlConsoleService sqlConsoleService) {
        this.sqlConsoleService = sqlConsoleService;
    }

    @PostMapping("/execute")
    @Operation(summary = "Run a PartiQL/SQL statement against DynamoDB Local through the JDBC driver")
    public SqlResponse execute(@RequestBody SqlRequest request) {
        return sqlConsoleService.execute(request.sql());
    }

    @GetMapping("/schema")
    @Operation(summary = "List every table with its key and sampled attribute names")
    public List<TableSchema> schema() {
        return sqlConsoleService.schema();
    }
}
