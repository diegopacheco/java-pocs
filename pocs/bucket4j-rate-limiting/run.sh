#!/bin/bash
./mvnw clean compile exec:java -Dexec.mainClass="Main" -Dexec.classpathScope=runtime
