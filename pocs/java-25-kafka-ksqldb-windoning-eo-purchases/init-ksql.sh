#!/bin/bash
MAX_ATTEMPTS=30
ATTEMPT=0
while [ $ATTEMPT -lt $MAX_ATTEMPTS ]; do
  curl -s http://localhost:8088/info > /dev/null 2>&1
  if [ $? -eq 0 ]; then
    break
  fi
  ATTEMPT=$((ATTEMPT+1))
  sleep 1
done
if [ $ATTEMPT -eq $MAX_ATTEMPTS ]; then
  exit 1
fi
cat init-ksqldb.sql | while IFS= read -r line; do
  if [ ! -z "$line" ] && [[ ! "$line" =~ ^[[:space:]]*$ ]]; then
    curl -s -X POST http://localhost:8088/ksql \
      -H "Content-Type: application/vnd.ksql.v1+json" \
      -d "{\"ksql\": \"$line\", \"streamsProperties\": {}}" > /dev/null
    sleep 1
  fi
done
