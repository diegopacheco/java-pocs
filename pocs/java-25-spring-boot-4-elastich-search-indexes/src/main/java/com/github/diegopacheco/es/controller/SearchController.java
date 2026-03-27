package com.github.diegopacheco.es.controller;

import com.github.diegopacheco.es.es.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> search(
            @RequestParam String q,
            @RequestParam String from,
            @RequestParam String to) throws IOException {
        LocalDate fromDate = LocalDate.parse(from);
        LocalDate toDate = LocalDate.parse(to);
        List<Map<String, Object>> results = searchService.search(q, fromDate, toDate);
        return ResponseEntity.ok(Map.of("query", q, "results", results, "total", results.size()));
    }

    @GetMapping("/by-index")
    public ResponseEntity<Map<String, Object>> searchByIndex(@RequestParam String name) throws IOException {
        List<Map<String, Object>> results = searchService.searchByIndex(name);
        return ResponseEntity.ok(Map.of("index", name, "results", results, "total", results.size()));
    }

    @GetMapping("/today")
    public ResponseEntity<Map<String, Object>> searchToday(@RequestParam String q) throws IOException {
        List<Map<String, Object>> results = searchService.searchCurrentIndex(q);
        return ResponseEntity.ok(Map.of("query", q, "results", results, "total", results.size()));
    }
}
