### Build

```bash
./mvnw clean install
```

### Generate Certificate

```bash
keytool -genkeypair -alias tomcat -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore keystore.p12 -validity 3650
```

### Config

src/main/resources/application.properties

```properties
server.port=8443
server.http2.enabled=true
server.ssl.key-store=classpath:keystore.p12
server.ssl.key-store-password=changeit
server.ssl.key-store-type=PKCS12
```

### Run

```
./mvnw spring-boot:run
```

```
/home/diego/.sdkman/candidates/java/23.0.2-amzn/bin/java -javaagent:/home/diego/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/lib/idea_rt.jar=42329 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-http2/target/classes:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-web/3.4.4/spring-boot-starter-web-3.4.4.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter/3.4.4/spring-boot-starter-3.4.4.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot/3.4.4/spring-boot-3.4.4.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.4.4/spring-boot-autoconfigure-3.4.4.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.4.4/spring-boot-starter-logging-3.4.4.jar:/home/diego/.m2/repository/ch/qos/logback/logback-classic/1.5.18/logback-classic-1.5.18.jar:/home/diego/.m2/repository/ch/qos/logback/logback-core/1.5.18/logback-core-1.5.18.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.24.3/log4j-to-slf4j-2.24.3.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-api/2.24.3/log4j-api-2.24.3.jar:/home/diego/.m2/repository/org/slf4j/jul-to-slf4j/2.0.17/jul-to-slf4j-2.0.17.jar:/home/diego/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/home/diego/.m2/repository/org/yaml/snakeyaml/2.3/snakeyaml-2.3.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.4.4/spring-boot-starter-json-3.4.4.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.18.3/jackson-databind-2.18.3.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.18.3/jackson-annotations-2.18.3.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.18.3/jackson-core-2.18.3.jar:/home/diego/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.18.3/jackson-datatype-jdk8-2.18.3.jar:/home/diego/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.18.3/jackson-datatype-jsr310-2.18.3.jar:/home/diego/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.18.3/jackson-module-parameter-names-2.18.3.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/3.4.4/spring-boot-starter-tomcat-3.4.4.jar:/home/diego/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/10.1.39/tomcat-embed-core-10.1.39.jar:/home/diego/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/10.1.39/tomcat-embed-el-10.1.39.jar:/home/diego/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/10.1.39/tomcat-embed-websocket-10.1.39.jar:/home/diego/.m2/repository/org/springframework/spring-web/6.2.5/spring-web-6.2.5.jar:/home/diego/.m2/repository/org/springframework/spring-beans/6.2.5/spring-beans-6.2.5.jar:/home/diego/.m2/repository/org/springframework/spring-webmvc/6.2.5/spring-webmvc-6.2.5.jar:/home/diego/.m2/repository/org/springframework/spring-aop/6.2.5/spring-aop-6.2.5.jar:/home/diego/.m2/repository/org/springframework/spring-context/6.2.5/spring-context-6.2.5.jar:/home/diego/.m2/repository/org/springframework/spring-expression/6.2.5/spring-expression-6.2.5.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-actuator/3.4.4/spring-boot-starter-actuator-3.4.4.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-actuator-autoconfigure/3.4.4/spring-boot-actuator-autoconfigure-3.4.4.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-actuator/3.4.4/spring-boot-actuator-3.4.4.jar:/home/diego/.m2/repository/io/micrometer/micrometer-observation/1.14.5/micrometer-observation-1.14.5.jar:/home/diego/.m2/repository/io/micrometer/micrometer-commons/1.14.5/micrometer-commons-1.14.5.jar:/home/diego/.m2/repository/io/micrometer/micrometer-jakarta9/1.14.5/micrometer-jakarta9-1.14.5.jar:/home/diego/.m2/repository/io/micrometer/micrometer-core/1.14.5/micrometer-core-1.14.5.jar:/home/diego/.m2/repository/org/hdrhistogram/HdrHistogram/2.2.2/HdrHistogram-2.2.2.jar:/home/diego/.m2/repository/org/latencyutils/LatencyUtils/2.0.3/LatencyUtils-2.0.3.jar:/home/diego/.m2/repository/org/slf4j/slf4j-api/2.0.17/slf4j-api-2.0.17.jar:/home/diego/.m2/repository/org/springframework/spring-core/6.2.5/spring-core-6.2.5.jar:/home/diego/.m2/repository/org/springframework/spring-jcl/6.2.5/spring-jcl-6.2.5.jar com.github.diegopacheco.sandboxspring.Application

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.4)

2025-04-04T23:57:21.412-07:00  INFO 127546 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 23.0.2 with PID 127546 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-http2/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-http2)
2025-04-04T23:57:21.417-07:00  INFO 127546 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2025-04-04T23:57:22.769-07:00  INFO 127546 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8443 (https)
2025-04-04T23:57:22.786-07:00  INFO 127546 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-04-04T23:57:22.786-07:00  INFO 127546 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.39]
2025-04-04T23:57:22.824-07:00  INFO 127546 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-04-04T23:57:22.825-07:00  INFO 127546 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1327 ms
2025-04-04T23:57:23.386-07:00  INFO 127546 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2025-04-04T23:57:23.668-07:00  INFO 127546 --- [           main] o.a.t.util.net.NioEndpoint.certificate   : Connector [https-jsse-nio-8443], TLS virtual host [_default_], certificate type [UNDEFINED] configured from keystore [/home/diego/.keystore] using alias [tomcat] with trust store [null]
2025-04-04T23:57:23.682-07:00  INFO 127546 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8443 (https) with context path '/'
2025-04-04T23:57:23.710-07:00  INFO 127546 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 2.779 seconds (process running for 3.158)
Spring Boot 3.4.x working! 
2025-04-04T23:57:36.634-07:00  INFO 127546 --- [nio-8443-exec-6] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-04-04T23:57:36.634-07:00  INFO 127546 --- [nio-8443-exec-6] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-04-04T23:57:36.635-07:00  INFO 127546 --- [nio-8443-exec-6] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
```

### Test

```bash
./test-http2-request.sh
```

```
❯ ./test-http2-request.sh
HTTP/2 200
content-type: text/plain;charset=UTF-8
content-length: 27
date: Sat, 05 Apr 2025 06:57:36 GMT
```