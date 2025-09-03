FROM openjdk:21-jdk-slim
WORKDIR /app

COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B

COPY src ./src

RUN ./mvnw clean compile -B
CMD ["./mvnw", "exec:java", "-Dexec.mainClass=Main", "-Dexec.classpathScope=runtime"]