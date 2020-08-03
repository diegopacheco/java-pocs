#!/bin/bash

#./mvnw exec:java -Dexec.mainClass="Main" -Dexec.classpathScope=runtime
mvn org.pitest:pitest-maven:mutationCoverage
