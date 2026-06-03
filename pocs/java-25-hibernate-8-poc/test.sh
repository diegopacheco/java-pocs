#!/bin/bash
set -e
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"
podman-compose up -d
echo "waiting for mysql"
tries=0
until podman exec hibernate8-mysql mysqladmin ping -uroot -proot --silent >/dev/null 2>&1; do
  tries=$((tries+1))
  if [ "$tries" -gt 60 ]; then
    echo "mysql failed to start"
    exit 1
  fi
  sleep 1
done
echo "mysql is ready"
./mvnw clean test
