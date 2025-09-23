FROM openjdk:25-jdk
WORKDIR /app
COPY target/java-25-spring-session-redis-1.0-SNAPSHOT.war app.war
EXPOSE 8080
CMD ["java", "-jar", "app.war"]