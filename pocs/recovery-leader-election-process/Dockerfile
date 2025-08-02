FROM eclipse-temurin:23-jdk
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests
ENV SERVER_PORT=8080
CMD ["sh", "-c", "java -jar target/*.jar --server.port=${SERVER_PORT}"]