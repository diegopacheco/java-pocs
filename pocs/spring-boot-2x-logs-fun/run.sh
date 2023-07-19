#!/bin/bash

./mvnw clean install
java -jar -Dserver.tomcat.basedir=target/log -Dserver.tomcat.accesslog.enabled=true target/spring-boot-2x-logs-fun-1.0-SNAPSHOT.war

