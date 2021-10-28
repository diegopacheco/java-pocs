#!/bin/bash

java -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=script:main.btm,boot:${BYTEMAN_HOME}/lib/byteman.jar \
 -Dorg.jboss.byteman.transform.all \
 -jar target/byteman-fun-1.0-SNAPSHOT.jar Hey Some args
