package com.bookstore.web.dto;

import java.util.List;

public record TableSchema(String name, List<String> keys, List<String> attributes) {
}
