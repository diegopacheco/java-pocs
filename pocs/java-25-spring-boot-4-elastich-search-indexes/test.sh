#!/bin/bash
echo "=== Testing Elasticsearch Index App ==="
echo ""
TODAY=$(date +%Y-%m-%d)
YESTERDAY=$(date -v-1d +%Y-%m-%d)
DAY_BEFORE=$(date -v-2d +%Y-%m-%d)
echo "--- GET /api/index/current ---"
curl -s http://localhost:8080/api/index/current | jq .
echo ""
echo "--- POST /api/index/$TODAY (create today) ---"
curl -s -X POST "http://localhost:8080/api/index/$TODAY" | jq .
echo ""
echo "--- POST /api/index/$YESTERDAY (create yesterday) ---"
curl -s -X POST "http://localhost:8080/api/index/$YESTERDAY" | jq .
echo ""
echo "--- POST /api/index/$DAY_BEFORE (create day before) ---"
curl -s -X POST "http://localhost:8080/api/index/$DAY_BEFORE" | jq .
echo ""
echo "--- POST /api/index/$TODAY (idempotent create) ---"
curl -s -X POST "http://localhost:8080/api/index/$TODAY" | jq .
echo ""
echo "--- GET /api/index/range?from=$DAY_BEFORE&to=$TODAY ---"
curl -s "http://localhost:8080/api/index/range?from=$DAY_BEFORE&to=$TODAY" | jq .
echo ""
echo "--- Feeding documents ---"
TODAY_IDX="index_$(date +%Y_%m_%d)"
YESTERDAY_IDX="index_$(date -v-1d +%Y_%m_%d)"
DAY_BEFORE_IDX="index_$(date -v-2d +%Y_%m_%d)"
curl -s -X POST "http://localhost:9200/$TODAY_IDX/_doc" -H "Content-Type: application/json" -d '{"title":"Spring Boot 4","content":"Spring Boot 4 is great","tags":["spring","java"]}'
curl -s -X POST "http://localhost:9200/$YESTERDAY_IDX/_doc" -H "Content-Type: application/json" -d '{"title":"Java 25","content":"Java 25 has new features","tags":["java","jdk"]}'
curl -s -X POST "http://localhost:9200/$DAY_BEFORE_IDX/_doc" -H "Content-Type: application/json" -d '{"title":"Elasticsearch 9","content":"Elasticsearch 9 with Spring Boot","tags":["elasticsearch","spring"]}'
curl -s -X POST "http://localhost:9200/_refresh" > /dev/null
echo "3 documents indexed"
echo ""
echo "--- GET /api/search?q=Spring&from=$DAY_BEFORE&to=$TODAY ---"
curl -s "http://localhost:8080/api/search?q=Spring&from=$DAY_BEFORE&to=$TODAY" | jq .
echo ""
echo "--- GET /api/search/today?q=Spring ---"
curl -s "http://localhost:8080/api/search/today?q=Spring" | jq .
echo ""
echo "--- GET /api/dashboard ---"
curl -s http://localhost:8080/api/dashboard | jq .
echo ""
echo "--- POST /api/index/retention ---"
curl -s -X POST http://localhost:8080/api/index/retention | jq .
echo ""
OLD_DATE=$(date -v-5d +%Y-%m-%d)
echo "--- POST /api/index/$OLD_DATE (create old index) ---"
curl -s -X POST "http://localhost:8080/api/index/$OLD_DATE" | jq .
echo ""
echo "--- DELETE /api/index/$OLD_DATE ---"
curl -s -X DELETE "http://localhost:8080/api/index/$OLD_DATE" | jq .
echo ""
echo "--- DELETE /api/index/$OLD_DATE (delete again, should be false) ---"
curl -s -X DELETE "http://localhost:8080/api/index/$OLD_DATE" | jq .
echo ""
echo "=== All tests completed ==="
