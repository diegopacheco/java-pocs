package com.bookstore.web;

public record ApiError(int status, String error, String message) {
}
