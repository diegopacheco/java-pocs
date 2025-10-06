FROM openjdk:25-jdk-slim
WORKDIR /app
COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src
RUN ./mvnw clean package -DskipTests
CMD ["./mvnw", "exec:java", "-Dexec.mainClass=Main"]
