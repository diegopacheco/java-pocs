package com.bookstore.model;

public record Book(String id, String title, String author, int totalPages, int pagesRead) {
}
