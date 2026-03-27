package com.github.diegopacheco.es.es;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.ReindexResponse;
import com.github.diegopacheco.es.config.ElasticsearchConfig;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class RotateService {

    private final IndexService indexService;
    private final ElasticsearchClient client;
    private final ElasticsearchConfig config;
    private final WindowState windowState;

    public RotateService(IndexService indexService, ElasticsearchClient client, ElasticsearchConfig config, WindowState windowState) {
        this.indexService = indexService;
        this.client = client;
        this.config = config;
        this.windowState = windowState;
    }

    public Map<String, Object> rotate(LocalDate targetDate) throws IOException {
        int retention = config.getRetentionDays();
        LocalDate windowStart = targetDate.minusDays(retention - 1);
        Map<String, Object> result = new LinkedHashMap<>();

        client.indices().refresh(r -> r.index("_all"));

        List<String> expiredIndexes = findExpiredIndexes(windowStart);

        List<String> createdIndexes = new ArrayList<>();
        List<LocalDate> windowDates = new ArrayList<>();
        LocalDate d = windowStart;
        while (!d.isAfter(targetDate)) {
            windowDates.add(d);
            boolean created = indexService.createIndex(d);
            if (created) {
                createdIndexes.add(indexService.getIndexName(d));
            }
            d = d.plusDays(1);
        }
        result.put("createdIndexes", createdIndexes);

        int docsFed = feedDocuments(windowDates);
        result.put("docsFed", docsFed);

        Map<String, Object> migrationResult = migrateAndDeleteExpired(expiredIndexes, targetDate);
        result.putAll(migrationResult);

        client.indices().refresh(r -> r.index("_all"));
        windowState.setWindowEnd(targetDate);
        result.put("windowStart", windowStart.toString());
        result.put("windowEnd", targetDate.toString());
        return result;
    }

    private List<String> findExpiredIndexes(LocalDate windowStart) throws IOException {
        Set<String> existingBefore = indexService.getExistingIndexes();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy_MM_dd");
        List<String> expiredIndexes = new ArrayList<>();
        for (String idx : existingBefore) {
            try {
                String datePart = idx.substring(config.getIndexPrefix().length() + 1);
                LocalDate idxDate = LocalDate.parse(datePart, fmt);
                if (idxDate.isBefore(windowStart)) {
                    expiredIndexes.add(idx);
                }
            } catch (Exception ignored) {}
        }
        return expiredIndexes;
    }

    private int feedDocuments(List<LocalDate> windowDates) throws IOException {
        String[] titles = {"Rotating indexes", "Sliding window update", "New data ingested"};
        String[] contents = {
            "Index rotated as part of sliding window",
            "Window shifted to new date range",
            "Fresh data available in index"
        };
        String[] tags = {"rotation", "window", "data"};
        int docsFed = 0;
        for (LocalDate wd : windowDates) {
            String idxName = indexService.getIndexName(wd);
            for (int i = 0; i < 3; i++) {
                final int idx = i;
                final String ts = wd.atTime(9 + i * 3, 0).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                client.index(r -> r.index(idxName).document(
                    Map.of(
                        "title", titles[idx] + " " + wd,
                        "content", contents[idx] + " " + idxName,
                        "timestamp", ts,
                        "tags", List.of(tags[idx], "auto")
                    )
                ));
                docsFed++;
            }
        }
        return docsFed;
    }

    private Map<String, Object> migrateAndDeleteExpired(List<String> expiredIndexes, LocalDate targetDate) throws IOException {
        List<String> migrated = new ArrayList<>();
        List<String> deleted = new ArrayList<>();
        long totalMigrated = 0;

        if (!expiredIndexes.isEmpty()) {
            String latestWindowIndex = indexService.getIndexName(targetDate);
            for (String expiredIdx : expiredIndexes) {
                try {
                    client.indices().refresh(r -> r.index(expiredIdx));
                    ReindexResponse reindexResponse = client.reindex(r -> r
                            .source(s -> s.index(expiredIdx))
                            .dest(dest -> dest.index(latestWindowIndex))
                    );
                    long count = reindexResponse.total() != null ? reindexResponse.total() : 0;
                    totalMigrated += count;
                    migrated.add(expiredIdx + " (" + count + " docs -> " + latestWindowIndex + ")");
                    client.indices().delete(del -> del.index(expiredIdx));
                    deleted.add(expiredIdx);
                } catch (Exception ignored) {}
            }
        }

        return Map.of(
            "migratedFrom", migrated,
            "totalDocsMigrated", totalMigrated,
            "deletedIndexes", deleted
        );
    }
}
