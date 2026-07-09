package com.diegopacheco.pgrustfun.book.domain;

import java.util.List;

public record BookPage(List<Book> content, int page, int size, long totalElements, int totalPages) {
}

