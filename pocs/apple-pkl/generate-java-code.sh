#!/bin/bash

#./mvnw clean install

java -cp target/lib \
    -jar target/lib/pkl-codegen-java-0.25.2.jar \
    -o target/generated \
    src/main/resources/intro.pkl