#!/bin/bash

BASE_URL="http://localhost:8080/api/votes"

echo "Testing Voting Application..."
echo "=================================="

echo "1. Getting all votes (should show initial state):"
curl -s "$BASE_URL" | jq . || curl -s "$BASE_URL"

echo -e "\n2. Casting votes for Option A (5 votes):"
for i in {1..5}; do
    echo "Vote $i for Option A:"
    curl -s -X POST "$BASE_URL/Option A" | jq . || curl -s -X POST "$BASE_URL/Option A"
    sleep 1
done

echo -e "\n3. Casting votes for Option B (3 votes):"
for i in {1..3}; do
    echo "Vote $i for Option B:"
    curl -s -X POST "$BASE_URL/Option B" | jq . || curl -s -X POST "$BASE_URL/Option B"
    sleep 1
done

echo -e "\n4. Casting votes for Option C (7 votes):"
for i in {1..7}; do
    echo "Vote $i for Option C:"
    curl -s -X POST "$BASE_URL/Option C" | jq . || curl -s -X POST "$BASE_URL/Option C"
    sleep 1
done

echo -e "\n5. Final vote counts:"
curl -s "$BASE_URL" | jq . || curl -s "$BASE_URL"

echo -e "\n6. Getting individual vote for Option A:"
curl -s "$BASE_URL/Option A" | jq . || curl -s "$BASE_URL/Option A"

echo -e "\n7. Testing WebSocket endpoint (connection info):"
echo "WebSocket endpoint available at: ws://localhost:8080/ws"
echo "Subscribe to: /topic/votes"

echo -e "\nTest completed!"
echo "You can also test the WebSocket functionality by connecting to ws://localhost:8080/ws"
echo "and subscribing to /topic/votes to see real-time vote updates."