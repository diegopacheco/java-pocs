package com.github.diegopacheco.es;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.github.diegopacheco.es.es.IndexService;
import com.github.diegopacheco.es.es.SearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.elasticsearch.ElasticsearchContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
public class ElasticsearchIntegrationTest {

    @Container
    static ElasticsearchContainer elasticsearch =
            new ElasticsearchContainer("docker.elastic.co/elasticsearch/elasticsearch:9.0.2")
                    .withEnv("discovery.type", "single-node")
                    .withEnv("xpack.security.enabled", "false")
                    .withEnv("ES_JAVA_OPTS", "-Xms512m -Xmx512m");

    @DynamicPropertySource
    static void elasticsearchProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.elasticsearch.uris", elasticsearch::getHttpHostAddress);
    }

    @Autowired
    private IndexService indexService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private ElasticsearchClient client;

    @BeforeEach
    void cleanup() throws IOException {
        try {
            client.indices().delete(d -> d.index("index_*"));
        } catch (Exception ignored) {}
    }

    @Test
    void testMultiIndexQuery() throws Exception {
        System.out.println("=== testMultiIndexQuery ===");
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        LocalDate dayBefore = today.minusDays(2);

        indexService.createIndex(today);
        indexService.createIndex(yesterday);
        indexService.createIndex(dayBefore);

        String todayIdx = indexService.getIndexName(today);
        String yesterdayIdx = indexService.getIndexName(yesterday);
        String dayBeforeIdx = indexService.getIndexName(dayBefore);
        System.out.println("  Created 3 indexes: " + todayIdx + ", " + yesterdayIdx + ", " + dayBeforeIdx);

        client.index(i -> i.index(todayIdx).document(
                Map.of("title", "software release", "content", "Spring Boot 4 released today", "tags", List.of("software"))));
        client.index(i -> i.index(yesterdayIdx).document(
                Map.of("title", "software update", "content", "Java 25 features announced for software", "tags", List.of("software"))));
        client.index(i -> i.index(dayBeforeIdx).document(
                Map.of("title", "software tips", "content", "Managing software indexes at scale", "tags", List.of("software"))));
        System.out.println("  Fed 1 doc per index (3 total)");

        client.indices().refresh(r -> r.index(todayIdx, yesterdayIdx, dayBeforeIdx));

        List<Map<String, Object>> results = searchService.search("Spring", dayBefore, today);
        System.out.println("  Search 'Spring' across 3 indexes -> " + results.size() + " results");
        assertFalse(results.isEmpty());

        boolean foundInTodayIndex = results.stream().anyMatch(r -> todayIdx.equals(r.get("_index")));
        System.out.println("  Found in today's index: " + foundInTodayIndex);
        assertTrue(foundInTodayIndex);

        List<Map<String, Object>> allResults = searchService.search("software", dayBefore, today);
        System.out.println("  Search 'software' across 3 indexes -> " + allResults.size() + " results");
        assertEquals(3, allResults.size());

        long distinctIndexes = allResults.stream().map(r -> r.get("_index")).distinct().count();
        System.out.println("  Results came from " + distinctIndexes + " distinct indexes");
        assertEquals(3, distinctIndexes);
        System.out.println("  PASSED: multi-index search works across all 3 indexes");
    }

    @Test
    void testConcurrentIndexCreation() throws Exception {
        System.out.println("=== testConcurrentIndexCreation ===");
        LocalDate date = LocalDate.now();
        int threadCount = 10;
        System.out.println("  Launching " + threadCount + " threads to create index: " + indexService.getIndexName(date));
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);
        AtomicInteger errorCount = new AtomicInteger(0);
        List<Exception> exceptions = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    indexService.createIndex(date);
                } catch (Exception e) {
                    errorCount.incrementAndGet();
                    synchronized (exceptions) {
                        exceptions.add(e);
                    }
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
        executor.shutdown();

        boolean exists = indexService.indexExists(indexService.getIndexName(date));
        System.out.println("  All " + threadCount + " threads completed, errors: " + errorCount.get());
        System.out.println("  Index exists after concurrent creation: " + exists);
        assertTrue(exists);
        assertEquals(0, errorCount.get(), "No errors should occur: " + exceptions);
        System.out.println("  PASSED: " + threadCount + " concurrent creates, zero errors, idempotent");
    }

    @Test
    void testDeleteIndex() throws Exception {
        System.out.println("=== testDeleteIndex ===");
        LocalDate date = LocalDate.now().minusDays(5);
        String indexName = indexService.getIndexName(date);

        indexService.createIndex(date);
        boolean existsAfterCreate = indexService.indexExists(indexName);
        System.out.println("  Created index: " + indexName + ", exists: " + existsAfterCreate);
        assertTrue(existsAfterCreate);

        boolean deleted = indexService.deleteIndex(date);
        System.out.println("  Deleted index: " + indexName + ", success: " + deleted);
        assertTrue(deleted);

        boolean existsAfterDelete = indexService.indexExists(indexName);
        System.out.println("  Exists after delete: " + existsAfterDelete);
        assertFalse(existsAfterDelete);

        boolean deletedAgain = indexService.deleteIndex(date);
        System.out.println("  Double-delete returned: " + deletedAgain + " (expected false)");
        assertFalse(deletedAgain);
        System.out.println("  PASSED: create, delete, verify gone, double-delete safe");
    }
}
