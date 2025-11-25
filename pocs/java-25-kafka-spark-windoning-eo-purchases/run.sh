#!/bin/bash
java -Djdk.security.auth.subject.getSubject.useAccessController=true \
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
     -javaagent:target/java-25-kafka-streams-windoning-eo-purchases-1.0-SNAPSHOT-agent.jar \
     -jar target/java-25-kafka-streams-windoning-eo-purchases-1.0-SNAPSHOT.war
