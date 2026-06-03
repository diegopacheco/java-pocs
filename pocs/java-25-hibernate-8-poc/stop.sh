#!/bin/bash
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"
pkill -f spring-boot:run 2>/dev/null
pkill -f sandboxspring.Application 2>/dev/null
podman-compose down
