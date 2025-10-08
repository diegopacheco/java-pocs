#!/bin/bash
set -e
echo "Testing CDC pipeline..."
echo ""
echo "Generating data via REST endpoint..."
RESPONSE=$(curl -s http://localhost:8080/generate)
echo "Response: $RESPONSE"
echo ""
sleep 1
echo "Showing Kafka logs..."
podman logs debezium-cdc-fun-kafka-1 --tail 20
echo ""
echo "Showing Debezium logs..."
podman logs debezium-cdc-fun-debezium-1 --tail 30
echo ""
echo "Showing Go consumer logs..."
podman logs debezium-cdc-fun-go-consumer-1 --tail 20
echo ""
echo "Getting all data from Java app..."
curl -s http://localhost:8080/getdata | jq .
echo ""
echo "Test completed!"
