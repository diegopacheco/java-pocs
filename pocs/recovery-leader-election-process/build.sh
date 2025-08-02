#!/bin/bash

./mvnw clean package
docker build -t spring-boot-app:latest .