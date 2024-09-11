#!/bin/bash

ulimit -n 65535

./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="\
  -XX:+UseZGC \
  -Xms8G \
  -Xmx8G \
  -XX:MaxGCPauseMillis=200 \
  -XX:+UseStringDeduplication \
  -XX:+OptimizeStringConcat \
  -XX:+UseCompressedOops \
  -XX:+AlwaysPreTouch \
  -XX:+UseNUMA \
  -XX:+DisableExplicitGC"

