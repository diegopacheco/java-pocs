FROM amazoncorretto:23-jdk
WORKDIR /app
COPY target/java-21-spring-boot-3-postgres-partition-1.0-SNAPSHOT.war app.war
EXPOSE 8080
CMD ["java", "-jar", "app.war"]