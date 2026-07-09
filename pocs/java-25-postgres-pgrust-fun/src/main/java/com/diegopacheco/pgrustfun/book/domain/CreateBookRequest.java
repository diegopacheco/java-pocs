package com.diegopacheco.pgrustfun.book.domain;

public record CreateBookRequest(String title, String author, String isbn, Integer publishedYear) {
}

