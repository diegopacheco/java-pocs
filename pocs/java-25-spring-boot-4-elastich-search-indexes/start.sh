#!/bin/bash
podman-compose up -d
echo "Waiting for Elasticsearch..."
until curl -s http://localhost:9200 > /dev/null 2>&1; do
  sleep 1
done
echo "Elasticsearch is ready"
cd dashboard && bun install > /dev/null 2>&1 && cd ..
