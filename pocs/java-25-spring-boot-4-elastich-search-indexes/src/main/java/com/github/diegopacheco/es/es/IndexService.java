package com.github.diegopacheco.es.es;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.cat.IndicesResponse;
import co.elastic.clients.elasticsearch.cat.indices.IndicesRecord;
import com.github.diegopacheco.es.config.ElasticsearchConfig;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IndexService {

    private final ElasticsearchClient client;
    private final ElasticsearchConfig config;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy_MM_dd");

    public IndexService(ElasticsearchClient client, ElasticsearchConfig config) {
        this.client = client;
        this.config = config;
    }

    public String getIndexName(LocalDate date) {
        return config.getIndexPrefix() + "_" + date.format(FORMATTER);
    }

    public String getCurrentIndex() {
        return getIndexName(LocalDate.now());
    }

    public boolean indexExists(String indexName) throws IOException {
        try {
            IndicesResponse catResponse = client.cat().indices(r -> r.index(indexName));
            return !catResponse.indices().isEmpty();
        } catch (co.elastic.clients.elasticsearch._types.ElasticsearchException e) {
            if (e.getMessage() != null && e.getMessage().contains("index_not_found_exception")) {
                return false;
            }
            throw e;
        }
    }

    public boolean createIndex(LocalDate date) throws IOException {
        String indexName = getIndexName(date);
        try {
            client.indices().create(c -> c.index(indexName));
            return true;
        } catch (co.elastic.clients.elasticsearch._types.ElasticsearchException e) {
            if (e.getMessage() != null && e.getMessage().contains("resource_already_exists_exception")) {
                return false;
            }
            throw e;
        }
    }

    public boolean deleteIndex(LocalDate date) throws IOException {
        String indexName = getIndexName(date);
        try {
            client.indices().delete(d -> d.index(indexName));
            return true;
        } catch (co.elastic.clients.elasticsearch._types.ElasticsearchException e) {
            if (e.getMessage() != null && e.getMessage().contains("index_not_found_exception")) {
                return false;
            }
            throw e;
        }
    }

    public List<String> getIndexesForRange(LocalDate from, LocalDate to) {
        List<String> indexes = new ArrayList<>();
        LocalDate current = from;
        while (!current.isAfter(to)) {
            indexes.add(getIndexName(current));
            current = current.plusDays(1);
        }
        return indexes;
    }

    public Set<String> getExistingIndexes() throws IOException {
        IndicesResponse catResponse = client.cat().indices(r -> r.index(config.getIndexPrefix() + "_*"));
        return catResponse.indices().stream()
                .map(IndicesRecord::index)
                .collect(Collectors.toSet());
    }

    public void applyRetentionPolicy() throws IOException {
        LocalDate cutoff = LocalDate.now().minusDays(config.getRetentionDays());
        Set<String> existing = getExistingIndexes();
        for (String indexName : existing) {
            try {
                String datePart = indexName.substring(config.getIndexPrefix().length() + 1);
                LocalDate indexDate = LocalDate.parse(datePart, FORMATTER);
                if (indexDate.isBefore(cutoff)) {
                    client.indices().delete(d -> d.index(indexName));
                }
            } catch (Exception ignored) {}
        }
    }
}
