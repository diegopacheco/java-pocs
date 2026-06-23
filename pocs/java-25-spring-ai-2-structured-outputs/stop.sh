#!/bin/bash
if [ -f app.pid ]; then
  kill "$(cat app.pid)" 2>/dev/null
  rm -f app.pid
  echo "app stopped"
else
  pkill -f java-25-spring-ai-2-structured-outputs-1.0-SNAPSHOT.jar 2>/dev/null && echo "app stopped" || echo "app not running"
fi
