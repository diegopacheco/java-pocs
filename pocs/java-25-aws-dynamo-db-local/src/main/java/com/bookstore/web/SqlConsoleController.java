package com.bookstore.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.service.SqlConsoleService;
import com.bookstore.web.dto.SqlRequest;
import com.bookstore.web.dto.SqlResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
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
    @SecurityRequirements
    @Operation(summary = "Run a PartiQL/SQL statement against DynamoDB Local through the JDBC driver")
    public SqlResponse execute(@RequestBody SqlRequest request) {
        return sqlConsoleService.execute(request.sql());
    }
}
