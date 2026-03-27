#!/bin/bash
TODAY=$(date +%Y-%m-%d)
YESTERDAY=$(date -v-1d +%Y-%m-%d)
DAY_BEFORE=$(date -v-2d +%Y-%m-%d)
TODAY_IDX="index_$(date +%Y_%m_%d)"
YESTERDAY_IDX="index_$(date -v-1d +%Y_%m_%d)"
DAY_BEFORE_IDX="index_$(date -v-2d +%Y_%m_%d)"
echo "Creating indexes..."
curl -s -X POST "http://localhost:8080/api/index/$TODAY" | jq .
curl -s -X POST "http://localhost:8080/api/index/$YESTERDAY" | jq .
curl -s -X POST "http://localhost:8080/api/index/$DAY_BEFORE" | jq .
echo "Feeding data into $TODAY_IDX..."
curl -s -X POST "http://localhost:9200/$TODAY_IDX/_doc" -H "Content-Type: application/json" -d '{"id":"1","title":"Spring Boot 4 Released","content":"Spring Boot 4 brings major improvements to the framework","timestamp":"'"$TODAY"'T10:00:00","tags":["spring","java"]}'
curl -s -X POST "http://localhost:9200/$TODAY_IDX/_doc" -H "Content-Type: application/json" -d '{"id":"2","title":"Java 25 Features","content":"Java 25 introduces new language features and performance improvements","timestamp":"'"$TODAY"'T11:00:00","tags":["java","jdk"]}'
curl -s -X POST "http://localhost:9200/$TODAY_IDX/_doc" -H "Content-Type: application/json" -d '{"id":"3","title":"Elasticsearch Indexing","content":"Best practices for managing Elasticsearch indexes at scale","timestamp":"'"$TODAY"'T12:00:00","tags":["elasticsearch","indexing"]}'
echo ""
echo "Feeding data into $YESTERDAY_IDX..."
curl -s -X POST "http://localhost:9200/$YESTERDAY_IDX/_doc" -H "Content-Type: application/json" -d '{"id":"4","title":"Podman vs Docker","content":"Comparing container runtimes for production workloads","timestamp":"'"$YESTERDAY"'T09:00:00","tags":["podman","containers"]}'
curl -s -X POST "http://localhost:9200/$YESTERDAY_IDX/_doc" -H "Content-Type: application/json" -d '{"id":"5","title":"Gradle Build Optimization","content":"Techniques for speeding up Gradle builds in large projects","timestamp":"'"$YESTERDAY"'T14:00:00","tags":["gradle","build"]}'
curl -s -X POST "http://localhost:9200/$YESTERDAY_IDX/_doc" -H "Content-Type: application/json" -d '{"id":"6","title":"REST API Design","content":"Designing clean and efficient REST APIs with Spring Boot","timestamp":"'"$YESTERDAY"'T16:00:00","tags":["rest","api"]}'
echo ""
echo "Feeding data into $DAY_BEFORE_IDX..."
curl -s -X POST "http://localhost:9200/$DAY_BEFORE_IDX/_doc" -H "Content-Type: application/json" -d '{"id":"7","title":"Integration Testing","content":"Writing integration tests for Elasticsearch backed applications","timestamp":"'"$DAY_BEFORE"'T08:00:00","tags":["testing","integration"]}'
curl -s -X POST "http://localhost:9200/$DAY_BEFORE_IDX/_doc" -H "Content-Type: application/json" -d '{"id":"8","title":"Sliding Window Algorithm","content":"Implementing sliding window patterns for time-series data management","timestamp":"'"$DAY_BEFORE"'T13:00:00","tags":["algorithm","data"]}'
curl -s -X POST "http://localhost:9200/$DAY_BEFORE_IDX/_doc" -H "Content-Type: application/json" -d '{"id":"9","title":"JVM Performance Tuning","content":"Advanced JVM tuning for high throughput applications","timestamp":"'"$DAY_BEFORE"'T17:00:00","tags":["jvm","performance"]}'
echo ""
echo "Refreshing indexes..."
curl -s -X POST "http://localhost:9200/_refresh" > /dev/null
echo "Done feeding data into 3 indexes"
