#!/bin/bash

ulimit -n 65535

# GC Options
#  -XX:+UseZGC
#  -XX:+UseG1GC
#  -XX:+UseShenandoahGC
#  -XX:+UseParallelGC
#  -XX:+UseEpsilonGC -XX:+UnlockExperimentalVMOptions

./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="\
  -Dreactor.schedulers.defaultBoundedElasticOnVirtualThreads=true \
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