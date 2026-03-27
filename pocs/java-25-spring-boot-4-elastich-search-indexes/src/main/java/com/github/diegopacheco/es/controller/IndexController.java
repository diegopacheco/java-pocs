package com.github.diegopacheco.es.controller;

import com.github.diegopacheco.es.es.IndexService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/index")
public class IndexController {

    private final IndexService indexService;

    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @GetMapping("/current")
    public ResponseEntity<Map<String, String>> getCurrentIndex() {
        return ResponseEntity.ok(Map.of("index", indexService.getCurrentIndex()));
    }

    @PostMapping("/{date}")
    public ResponseEntity<Map<String, Object>> createIndex(@PathVariable String date) throws IOException {
        LocalDate localDate = LocalDate.parse(date);
        boolean created = indexService.createIndex(localDate);
        return ResponseEntity.ok(Map.of(
                "index", indexService.getIndexName(localDate),
                "created", created
        ));
    }

    @DeleteMapping("/{date}")
    public ResponseEntity<Map<String, Object>> deleteIndex(@PathVariable String date) throws IOException {
        LocalDate localDate = LocalDate.parse(date);
        boolean deleted = indexService.deleteIndex(localDate);
        return ResponseEntity.ok(Map.of(
                "index", indexService.getIndexName(localDate),
                "deleted", deleted
        ));
    }

    @GetMapping("/range")
    public ResponseEntity<Map<String, List<String>>> getIndexesForRange(
            @RequestParam String from,
            @RequestParam String to) {
        LocalDate fromDate = LocalDate.parse(from);
        LocalDate toDate = LocalDate.parse(to);
        List<String> indexes = indexService.getIndexesForRange(fromDate, toDate);
        return ResponseEntity.ok(Map.of("indexes", indexes));
    }

    @PostMapping("/retention")
    public ResponseEntity<Map<String, String>> applyRetention() throws IOException {
        indexService.applyRetentionPolicy();
        return ResponseEntity.ok(Map.of("status", "retention policy applied"));
    }
}
