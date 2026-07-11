package com.bookstore.web.dto;

import java.util.List;
import java.util.Map;

public record SqlResponse(List<String> columns, List<Map<String, Object>> rows, int rowCount, Integer updateCount) {
}
