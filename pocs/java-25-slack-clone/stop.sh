#!/usr/bin/env bash
set -euo pipefail
ROOT="$(cd "$(dirname "$0")" && pwd)"
podman-compose -f "$ROOT/podman-compose.yml" down
