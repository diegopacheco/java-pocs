#!/bin/bash

podman-compose up -d
echo "Waiting for Kafka to be ready..."
sleep 5
KAFKA_CONTAINER=$(podman ps -q -f "ancestor=docker.io/confluentinc/cp-kafka:7.5.0")
while ! podman exec $KAFKA_CONTAINER kafka-broker-api-versions --bootstrap-server localhost:9092 > /dev/null 2>&1; do
  sleep 1
done
echo "Kafka is ready"
echo "Creating purchases topic..."
podman exec $KAFKA_CONTAINER kafka-topics --create --topic purchases --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1 --if-not-exists
echo "Topic created"
