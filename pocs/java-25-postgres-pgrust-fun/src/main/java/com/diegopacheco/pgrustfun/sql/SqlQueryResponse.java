package com.diegopacheco.pgrustfun.sql;

import java.util.List;
import java.util.Map;

public record SqlQueryResponse(List<String> columns, List<Map<String, Object>> rows, Integer updatedCount) {
}

