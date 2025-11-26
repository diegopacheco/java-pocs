#!/bin/bash
JAVA_CMD="$JAVA_HOME_21/bin/java"
if [ -z "$JAVA_HOME_21" ] && [ -n "$JAVA_HOME" ]; then
  JAVA_CMD="$JAVA_HOME/bin/java"
fi
if [ -z "$JAVA_HOME_21" ] && [ -z "$JAVA_HOME" ]; then
  JAVA_CMD="java"
fi
JAVA_VERSION=$("$JAVA_CMD" -version 2>&1 | head -n 1 | sed 's/[^0-9]*\([0-9][0-9]*\).*/\1/')
if [ "$JAVA_VERSION" != "21" ]; then
  echo "Java 21 required. Set JAVA_HOME_21 or JAVA_HOME to JDK 21." >&2
  exit 1
fi

"$JAVA_CMD" -Djdk.security.auth.subject.getSubject.useAccessController=true \
     --add-opens=java.base/java.lang=ALL-UNNAMED \
     --add-opens=java.base/java.lang.invoke=ALL-UNNAMED \
     --add-opens=java.base/java.lang.reflect=ALL-UNNAMED \
     --add-opens=java.base/java.io=ALL-UNNAMED \
     --add-opens=java.base/java.net=ALL-UNNAMED \
     --add-opens=java.base/java.nio=ALL-UNNAMED \
     --add-opens=java.base/java.util=ALL-UNNAMED \
     --add-opens=java.base/java.util.concurrent=ALL-UNNAMED \
     --add-opens=java.base/java.util.concurrent.atomic=ALL-UNNAMED \
     --add-opens=java.base/sun.nio.ch=ALL-UNNAMED \
     --add-opens=java.base/sun.nio.cs=ALL-UNNAMED \
     --add-opens=java.base/sun.security.action=ALL-UNNAMED \
     --add-opens=java.base/sun.util.calendar=ALL-UNNAMED \
     --add-opens=java.security.jgss/sun.security.krb5=ALL-UNNAMED \
     --add-opens=java.base/javax.security.auth=ALL-UNNAMED \
     -jar target/java-25-kafka-streams-windoning-eo-purchases-1.0-SNAPSHOT.jar
