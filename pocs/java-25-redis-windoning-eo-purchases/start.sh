#!/bin/bash
podman-compose up -d
echo "Waiting for Redis to be ready..."
REDIS_CONTAINER=$(podman ps -q -f "ancestor=docker.io/library/redis:7.4.2-alpine")
while ! podman exec $REDIS_CONTAINER redis-cli ping > /dev/null 2>&1; do
  sleep 1
done
echo "Redis is ready"
