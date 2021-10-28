#!/bin/bash

#
# Byteman as agent static
#
#java -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=listener:true,script:main.btm,boot:${BYTEMAN_HOME}/lib/byteman.jar \
# -Dorg.jboss.byteman.transform.all \
# -jar target/byteman-fun-1.0-SNAPSHOT.jar Hey Some args

#
# dynamic load with ${BYTEMAN_HOME}/bin/bminstall.sh PID
#
java -jar target/byteman-fun-1.0-SNAPSHOT.jar Hey Some args