package com.bookstore.web.dto;

import java.util.List;

public record CursorPage<T>(int size, int count, String nextToken, List<T> content) {
}
