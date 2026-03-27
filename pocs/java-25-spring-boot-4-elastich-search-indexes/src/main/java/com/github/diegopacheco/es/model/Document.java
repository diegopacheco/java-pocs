package com.github.diegopacheco.es.model;

import java.util.List;

public record Document(
        String id,
        String title,
        String content,
        String timestamp,
        List<String> tags
) {}
