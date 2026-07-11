package com.bookstore.web.dto;

import java.util.List;

public record PageResponse<T>(int page, int size, long total, int totalPages, List<T> content) {
}
