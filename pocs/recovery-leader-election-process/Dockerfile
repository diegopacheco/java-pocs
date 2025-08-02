FROM eclipse-temurin:23-jdk
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests
ENV SERVER_PORT=8080
COPY target/*.war app.war
CMD ["sh", "-c", "java -jar app.war --server.port=${SERVER_PORT}"]