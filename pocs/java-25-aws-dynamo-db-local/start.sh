#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"

mkdir -p logs

podman machine start >/dev/null 2>&1 || true

podman rm -f ddb-local >/dev/null 2>&1 || true
podman run -d --name ddb-local -p 8000:8000 amazon/dynamodb-local >/dev/null

echo "waiting for dynamodb-local on 8000"
until curl -s http://localhost:8000 >/dev/null 2>&1; do sleep 1; done
echo "dynamodb-local is ready"

./mvnw -q -DskipTests package

nohup java -jar target/java-25-aws-dynamo-db-local-1.0.0.jar > logs/app.out 2>&1 &
echo $! > app.pid
echo "app starting pid $(cat app.pid)"

echo "waiting for app on 8080"
until curl -s http://localhost:8080/actuator/health >/dev/null 2>&1; do sleep 1; done
echo "app is ready"
echo "swagger:     http://localhost:8080/swagger"
echo "sql console: http://localhost:8080/sql-console"
echo "health:      http://localhost:8080/actuator/health"
