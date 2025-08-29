FROM openjdk:23-jdk-slim
WORKDIR /app
COPY target/java-21-spring-boot-3-mysql-partition-1.0-SNAPSHOT.war app.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.war"]