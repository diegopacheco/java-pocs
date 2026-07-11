package com.bookstore.web.dto;

public record CreateBookRequest(String title, String author, int totalPages) {
}
