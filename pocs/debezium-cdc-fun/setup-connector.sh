#!/bin/bash
echo "Waiting for Debezium Connect to be ready..."
MAX_ATTEMPTS=30
ATTEMPT=0
while [ $ATTEMPT -lt $MAX_ATTEMPTS ]; do
  if curl -s http://localhost:8083/ > /dev/null 2>&1; then
    echo "Debezium Connect is ready!"
    break
  fi
  ATTEMPT=$((ATTEMPT+1))
  echo "Attempt $ATTEMPT/$MAX_ATTEMPTS - waiting..."
  sleep 1
done
if [ $ATTEMPT -eq $MAX_ATTEMPTS ]; then
  echo "Debezium Connect did not become ready in time"
  exit 1
fi
echo "Registering Debezium connector..."
curl -i -X POST -H "Content-Type: application/json" --data @debezium-connector.json http://localhost:8083/connectors
echo ""
echo "Connector registered!"
