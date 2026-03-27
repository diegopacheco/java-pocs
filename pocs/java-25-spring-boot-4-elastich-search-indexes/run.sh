#!/bin/bash
./start.sh
(cd dashboard && bun run dev) &
DASHBOARD_PID=$!
trap './stop.sh; kill $DASHBOARD_PID 2>/dev/null' EXIT
./gradlew bootRun
