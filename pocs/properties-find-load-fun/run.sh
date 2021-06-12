#!/bin/bash

./mvnw package
java -jar target/properties-find-load-fun-1.0-SNAPSHOT.jar 
