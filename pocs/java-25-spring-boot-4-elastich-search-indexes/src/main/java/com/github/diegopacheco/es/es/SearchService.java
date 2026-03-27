package com.github.diegopacheco.es.es;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.JsonData;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class SearchService {

    private final ElasticsearchClient client;
    private final IndexService indexService;

    public SearchService(ElasticsearchClient client, IndexService indexService) {
        this.client = client;
        this.indexService = indexService;
    }

    public List<Map<String, Object>> search(String query, LocalDate from, LocalDate to) throws IOException {
        List<String> indexes = indexService.getIndexesForRange(from, to);
        Set<String> existing = indexService.getExistingIndexes();
        List<String> targetIndexes = indexes.stream()
                .filter(existing::contains)
                .toList();
        if (targetIndexes.isEmpty()) {
            return List.of();
        }
        String pattern = "*" + query.toLowerCase() + "*";
        SearchResponse<JsonData> response = client.search(s -> s
                        .index(targetIndexes)
                        .query(q -> q.bool(b -> b
                                .should(sh -> sh.wildcard(w -> w.field("title").value(pattern).caseInsensitive(true)))
                                .should(sh -> sh.wildcard(w -> w.field("content").value(pattern).caseInsensitive(true)))
                                .should(sh -> sh.wildcard(w -> w.field("tags").value(pattern).caseInsensitive(true)))
                        )),
                JsonData.class
        );
        return extractResults(response);
    }

    public List<Map<String, Object>> searchCurrentIndex(String query) throws IOException {
        String currentIndex = indexService.getCurrentIndex();
        Set<String> existing = indexService.getExistingIndexes();
        if (!existing.contains(currentIndex)) {
            return List.of();
        }
        String pattern = "*" + query.toLowerCase() + "*";
        SearchResponse<JsonData> response = client.search(s -> s
                        .index(currentIndex)
                        .query(q -> q.bool(b -> b
                                .should(sh -> sh.wildcard(w -> w.field("title").value(pattern).caseInsensitive(true)))
                                .should(sh -> sh.wildcard(w -> w.field("content").value(pattern).caseInsensitive(true)))
                                .should(sh -> sh.wildcard(w -> w.field("tags").value(pattern).caseInsensitive(true)))
                        )),
                JsonData.class
        );
        return extractResults(response);
    }

    public List<Map<String, Object>> searchByIndex(String indexName) throws IOException {
        Set<String> existing = indexService.getExistingIndexes();
        if (!existing.contains(indexName)) {
            return List.of();
        }
        client.indices().refresh(r -> r.index(indexName));
        SearchResponse<JsonData> response = client.search(s -> s
                        .index(indexName)
                        .query(q -> q.bool(b -> b
                                .should(sh -> sh.wildcard(w -> w.field("title").value("*").caseInsensitive(true)))
                                .should(sh -> sh.wildcard(w -> w.field("content").value("*").caseInsensitive(true)))
                                .should(sh -> sh.wildcard(w -> w.field("tags").value("*").caseInsensitive(true)))
                        ))
                        .size(100),
                JsonData.class
        );
        return extractResults(response);
    }

    @SuppressWarnings("unchecked")
    private List<Map<String, Object>> extractResults(SearchResponse<JsonData> response) {
        List<Map<String, Object>> results = new ArrayList<>();
        for (Hit<JsonData> hit : response.hits().hits()) {
            if (hit.source() != null) {
                Map<String, Object> map = new HashMap<>(hit.source().to(Map.class));
                map.put("_index", hit.index());
                map.put("_id", hit.id());
                results.add(map);
            }
        }
        return results;
    }
}
