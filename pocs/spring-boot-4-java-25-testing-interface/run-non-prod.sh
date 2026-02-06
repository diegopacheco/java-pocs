#!/bin/bash
./mvnw clean package -DskipTests
echo "App running on: http://localhost:8081"
echo "Endpoints: http://localhost:8081/products"
echo "Endpoints: http://localhost:8081/product-create"
java -Dspring.profiles.active=dev -jar target/spring-boot-4-java-25-testing-interface-1.0-SNAPSHOT.war
