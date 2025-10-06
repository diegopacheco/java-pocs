#!/bin/bash

podman compose down
podman compose up -d --build

echo "Waiting for application to be ready..."
ATTEMPTS=0
MAX_ATTEMPTS=30
while [ $ATTEMPTS -lt $MAX_ATTEMPTS ]; do
    if podman ps | grep -q "hoverfly-api-simulation-app"; then
        echo "Application is running"
        break
    fi
    ATTEMPTS=$((ATTEMPTS + 1))
    sleep 1
done

if [ $ATTEMPTS -eq $MAX_ATTEMPTS ]; then
    echo "Timeout waiting for application"
    exit 1
fi

echo "Hoverfly Admin UI: http://localhost:8888"
echo "Simulated API Port: http://localhost:8500"
echo ""
podman compose logs -f app
