#!/bin/bash

podman-compose up -d
echo "Waiting for Kafka to be ready..."
while ! podman exec $(podman ps -q -f "ancestor=confluentinc/cp-kafka:latest") kafka-topics --bootstrap-server localhost:9092 --list > /dev/null 2>&1; do
  sleep 1
done
echo "Kafka is ready"
