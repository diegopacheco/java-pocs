FROM openjdk:25-jdk-slim
WORKDIR /app
COPY target/java-25-spring-supabase-1.0-SNAPSHOT.war app.war
EXPOSE 8080
CMD ["java", "-jar", "app.war"]