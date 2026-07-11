package com.bookstore.web.dto;

import java.util.List;

public record BatchPagesRequest(List<PageUpdate> updates) {
}
