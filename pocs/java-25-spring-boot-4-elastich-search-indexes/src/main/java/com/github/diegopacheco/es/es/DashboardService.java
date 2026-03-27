package com.github.diegopacheco.es.es;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.cat.indices.IndicesRecord;
import com.github.diegopacheco.es.config.ElasticsearchConfig;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class DashboardService {

    private final ElasticsearchClient client;
    private final ElasticsearchConfig config;
    private final IndexService indexService;
    private final WindowState windowState;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy_MM_dd");

    public DashboardService(ElasticsearchClient client, ElasticsearchConfig config, IndexService indexService, WindowState windowState) {
        this.client = client;
        this.config = config;
        this.indexService = indexService;
        this.windowState = windowState;
    }

    public Map<String, Object> getDashboardData() throws IOException {
        Map<String, Object> dashboard = new LinkedHashMap<>();

        List<Map<String, Object>> indexes = new ArrayList<>();
        try {
            var catResponse = client.cat().indices(r -> r.index(config.getIndexPrefix() + "_*"));
            for (IndicesRecord record : catResponse.indices()) {
                Map<String, Object> idx = new LinkedHashMap<>();
                idx.put("name", record.index());
                idx.put("docsCount", record.docsCount() != null ? record.docsCount() : "0");
                idx.put("storeSize", record.storeSize() != null ? record.storeSize() : "0b");
                idx.put("health", record.health() != null ? record.health() : "unknown");
                idx.put("status", record.status() != null ? record.status() : "unknown");
                try {
                    String datePart = record.index().substring(config.getIndexPrefix().length() + 1);
                    LocalDate indexDate = LocalDate.parse(datePart, FORMATTER);
                    idx.put("date", indexDate.toString());
                } catch (Exception e) {
                    idx.put("date", "unknown");
                }
                indexes.add(idx);
            }
        } catch (Exception ignored) {}
        indexes.sort(Comparator.comparing(m -> (String) m.get("name")));
        dashboard.put("indexes", indexes);

        LocalDate windowEnd = windowState.getWindowEnd();
        LocalDate windowStart = windowEnd.minusDays(config.getRetentionDays() - 1);
        String currentIndex = indexService.getIndexName(windowEnd);
        Map<String, Object> slidingWindow = new LinkedHashMap<>();
        slidingWindow.put("retentionDays", config.getRetentionDays());
        slidingWindow.put("windowStart", windowStart.toString());
        slidingWindow.put("windowEnd", windowEnd.toString());
        slidingWindow.put("currentIndex", currentIndex);

        List<String> windowIndexes = indexService.getIndexesForRange(windowStart, windowEnd);
        slidingWindow.put("windowIndexes", windowIndexes);
        dashboard.put("slidingWindow", slidingWindow);

        dashboard.put("totalIndexes", indexes.size());
        long totalDocs = indexes.stream()
                .mapToLong(m -> {
                    try { return Long.parseLong((String) m.get("docsCount")); }
                    catch (Exception e) { return 0; }
                })
                .sum();
        dashboard.put("totalDocs", totalDocs);

        return dashboard;
    }
}
