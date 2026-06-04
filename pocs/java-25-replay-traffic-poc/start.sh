#!/bin/bash
set -e
ROOT="$(cd "$(dirname "$0")" && pwd)"
cd "$ROOT"
mkdir -p logs
export TRAFFIC_LOG="$ROOT/traffic.log"

podman-compose -f infra/compose.yaml up -d

echo "waiting for mysql"
until podman exec bookstore-mysql mysqladmin ping -h127.0.0.1 -uroot -ppass --silent >/dev/null 2>&1; do
  sleep 1
done

echo "building bookstore-service"
(cd bookstore-service && ./mvnw -q -DskipTests package)
echo "building traffic-proxy"
(cd traffic-proxy && ./mvnw -q -DskipTests package)

echo "starting bookstore-service on 8080"
nohup java -jar bookstore-service/target/bookstore-service-1.0-SNAPSHOT.jar > logs/bookstore.log 2>&1 &
echo $! > logs/bookstore.pid

echo "waiting for bookstore-service"
until curl -fs http://localhost:8080/books >/dev/null 2>&1; do
  sleep 1
done

echo "starting traffic-proxy on 8000 (control api 8001)"
nohup java -jar traffic-proxy/target/traffic-proxy.jar > logs/proxy.log 2>&1 &
echo $! > logs/proxy.pid

echo "waiting for traffic-proxy"
until curl -fs http://localhost:8001/api/health >/dev/null 2>&1; do
  sleep 1
done

echo "installing ui deps"
(cd ui && bun install >/dev/null 2>&1)

echo "starting ui on 5173"
( cd ui && exec bun run dev ) > logs/ui.log 2>&1 &
echo $! > logs/ui.pid

echo "ready"
echo "proxy    http://localhost:8000"
echo "backend  http://localhost:8080"
echo "control  http://localhost:8001"
echo "ui       http://localhost:5173"
