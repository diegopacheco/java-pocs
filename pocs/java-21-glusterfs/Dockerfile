# Use OpenJDK 21 as base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Install GlusterFS client tools
RUN apt-get update && \
    apt-get install -y glusterfs-client && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Copy Maven wrapper and POM file
COPY .mvn/ .mvn/
COPY mvnw mvnw.cmd pom.xml ./

# Make mvnw executable
RUN chmod +x ./mvnw

# Download dependencies (this layer will be cached if pom.xml doesn't change)
RUN ./mvnw dependency:resolve

# Copy source code
COPY src/ src/

# Build the application
RUN ./mvnw compile

# Create mount point for GlusterFS
RUN mkdir -p /mnt/gluster

# Expose port if needed (adjust as required)
EXPOSE 8080

# Default command to run the application
CMD ["./mvnw", "exec:java", "-Dexec.mainClass=Main", "-Dexec.classpathScope=runtime"]