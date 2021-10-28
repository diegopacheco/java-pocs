#!/bin/bash

#
# Byteman as agent static (works)
#
#java -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=listener:true,script:main.btm,boot:${BYTEMAN_HOME}/lib/byteman.jar \
# -Dorg.jboss.byteman.transform.all \
# -jar target/byteman-fun-1.0-SNAPSHOT.jar Hey Some args

#
# verify rules
# ${BYTEMAN_HOME}/bin/bmcheck.sh -cp target/byteman-fun-1.0-SNAPSHOT.jar add.btm
#
# dynamic load with: 
# ${BYTEMAN_HOME}/bin/bminstall.sh PID
# ${BYTEMAN_HOME}/bin/bmsubmit.sh main.btm
#
# java -jar target/byteman-fun-1.0-SNAPSHOT.jar Hey Some args
java -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=listener:true,boot:${BYTEMAN_HOME}/lib/byteman.jar \
-Dorg.jboss.byteman.transform.all -jar target/byteman-fun-1.0-SNAPSHOT.jar Hey
