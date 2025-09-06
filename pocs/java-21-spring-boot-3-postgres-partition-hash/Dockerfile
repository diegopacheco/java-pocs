FROM openjdk:23-jdk-slim
WORKDIR /app
COPY mvnw mvnw.cmd pom.xml ./
COPY .mvn .mvn/
COPY src/ src/
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/java-21-spring-boot-3-postgres-partition-hash-1.0-SNAPSHOT.war"]