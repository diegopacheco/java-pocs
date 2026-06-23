#!/bin/bash
set -e
if [ -z "$OPENAI_API_KEY" ]; then
  echo "OPENAI_API_KEY is not set"
  exit 1
fi
if [ -z "$JAVA_HOME" ]; then
  export JAVA_HOME="$(cd "$(dirname "$(command -v java)")/.." && pwd)"
fi
./mvnw -q clean package -DskipTests
nohup java -jar target/java-25-spring-ai-2-structured-outputs-1.0-SNAPSHOT.jar > app.log 2>&1 &
echo $! > app.pid
for i in $(seq 1 90); do
  if curl -s http://localhost:8081/actuator/health | grep -q '"status":"UP"'; then
    echo "app is up on http://localhost:8081"
    exit 0
  fi
  sleep 1
done
echo "app failed to start, see app.log"
exit 1
