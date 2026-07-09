package com.diegopacheco.pgrustfun.sql;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "SQL Console")
public class SqlConsoleController {

    private final SqlConsoleService service;

    public SqlConsoleController(SqlConsoleService service) {
        this.service = service;
    }

    @PostMapping("/sql-console/query")
    @Operation(summary = "Run a single SQL statement against pgrust")
    public SqlQueryResponse query(@RequestBody SqlQueryRequest request) {
        return service.execute(request == null ? null : request.sql());
    }
}
