FROM openjdk:14-alpine
COPY target/demo-*.jar demo.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "demo.jar"]