FROM openjdk:25-jdk-slim

WORKDIR /app

COPY target/spring-apache-pulsar-fun-1.0-SNAPSHOT.war app.war

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "app.war"]