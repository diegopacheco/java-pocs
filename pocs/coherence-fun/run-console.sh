#!/bin/bash

mvn -DgroupId=com.oracle.coherence.ce -DartifactId=coherence -Dversion=20.06 dependency:get 
export COH_JAR=~/.m2/repository/com/oracle/coherence/ce/coherence/20.06/coherence-20.06.jar  
java -Dcoherence.wka=localhost -cp $COH_JAR com.tangosol.coherence.dslquery.QueryPlus   
