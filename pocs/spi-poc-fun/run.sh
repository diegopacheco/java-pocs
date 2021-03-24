#!/bin/bash

./mvnw exec:java -pl app -Dexec.mainClass="Main" -Dexec.classpathScope=runtime 

