#!/bin/bash
echo "=== Running ArchUnit architecture test suite ==="
./gradlew clean test
echo ""
echo "=== HTTP smoke test (needs MySQL up via ./start.sh and app via ./run.sh) ==="
curl -s -X POST http://localhost:8080/api/people -H "Content-Type: application/json" -d '{"firstName":"Diego","lastName":"Pacheco"}'
echo ""
curl -s http://localhost:8080/api/people
echo ""
curl -s "http://localhost:8080/api/people/search?firstName=Diego"
echo ""
