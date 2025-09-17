### Build

```bash
./mvnw clean install
```

### Run

```
./run.sh
```

```
/Users/diegopacheco/.sdkman/candidates/java/25-zulu/zulu-25.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=58492 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/diegopacheco/Documents/git/diegopacheco/java-pocs/pocs/java-25-spring-boot-3.5/target/classes:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-starter-web/3.5.5/spring-boot-starter-web-3.5.5.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-starter/3.5.5/spring-boot-starter-3.5.5.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot/3.5.5/spring-boot-3.5.5.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.5.5/spring-boot-autoconfigure-3.5.5.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.5.5/spring-boot-starter-logging-3.5.5.jar:/Users/diegopacheco/.m2/repository/ch/qos/logback/logback-classic/1.5.18/logback-classic-1.5.18.jar:/Users/diegopacheco/.m2/repository/ch/qos/logback/logback-core/1.5.18/logback-core-1.5.18.jar:/Users/diegopacheco/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.24.3/log4j-to-slf4j-2.24.3.jar:/Users/diegopacheco/.m2/repository/org/apache/logging/log4j/log4j-api/2.24.3/log4j-api-2.24.3.jar:/Users/diegopacheco/.m2/repository/org/slf4j/jul-to-slf4j/2.0.17/jul-to-slf4j-2.0.17.jar:/Users/diegopacheco/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/Users/diegopacheco/.m2/repository/org/yaml/snakeyaml/2.4/snakeyaml-2.4.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.5.5/spring-boot-starter-json-3.5.5.jar:/Users/diegopacheco/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.19.2/jackson-databind-2.19.2.jar:/Users/diegopacheco/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.19.2/jackson-annotations-2.19.2.jar:/Users/diegopacheco/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.19.2/jackson-core-2.19.2.jar:/Users/diegopacheco/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.19.2/jackson-datatype-jdk8-2.19.2.jar:/Users/diegopacheco/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.19.2/jackson-datatype-jsr310-2.19.2.jar:/Users/diegopacheco/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.19.2/jackson-module-parameter-names-2.19.2.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/3.5.5/spring-boot-starter-tomcat-3.5.5.jar:/Users/diegopacheco/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/10.1.44/tomcat-embed-core-10.1.44.jar:/Users/diegopacheco/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/10.1.44/tomcat-embed-el-10.1.44.jar:/Users/diegopacheco/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/10.1.44/tomcat-embed-websocket-10.1.44.jar:/Users/diegopacheco/.m2/repository/org/springframework/spring-web/6.2.10/spring-web-6.2.10.jar:/Users/diegopacheco/.m2/repository/org/springframework/spring-beans/6.2.10/spring-beans-6.2.10.jar:/Users/diegopacheco/.m2/repository/org/springframework/spring-webmvc/6.2.10/spring-webmvc-6.2.10.jar:/Users/diegopacheco/.m2/repository/org/springframework/spring-aop/6.2.10/spring-aop-6.2.10.jar:/Users/diegopacheco/.m2/repository/org/springframework/spring-context/6.2.10/spring-context-6.2.10.jar:/Users/diegopacheco/.m2/repository/org/springframework/spring-expression/6.2.10/spring-expression-6.2.10.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-starter-actuator/3.5.5/spring-boot-starter-actuator-3.5.5.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-actuator-autoconfigure/3.5.5/spring-boot-actuator-autoconfigure-3.5.5.jar:/Users/diegopacheco/.m2/repository/org/springframework/boot/spring-boot-actuator/3.5.5/spring-boot-actuator-3.5.5.jar:/Users/diegopacheco/.m2/repository/io/micrometer/micrometer-observation/1.15.3/micrometer-observation-1.15.3.jar:/Users/diegopacheco/.m2/repository/io/micrometer/micrometer-commons/1.15.3/micrometer-commons-1.15.3.jar:/Users/diegopacheco/.m2/repository/io/micrometer/micrometer-jakarta9/1.15.3/micrometer-jakarta9-1.15.3.jar:/Users/diegopacheco/.m2/repository/io/micrometer/micrometer-core/1.15.3/micrometer-core-1.15.3.jar:/Users/diegopacheco/.m2/repository/org/hdrhistogram/HdrHistogram/2.2.2/HdrHistogram-2.2.2.jar:/Users/diegopacheco/.m2/repository/org/latencyutils/LatencyUtils/2.0.3/LatencyUtils-2.0.3.jar:/Users/diegopacheco/.m2/repository/org/slf4j/slf4j-api/2.0.17/slf4j-api-2.0.17.jar:/Users/diegopacheco/.m2/repository/org/springframework/spring-core/6.2.10/spring-core-6.2.10.jar:/Users/diegopacheco/.m2/repository/org/springframework/spring-jcl/6.2.10/spring-jcl-6.2.10.jar com.github.diegopacheco.sandboxspring.Application

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.5.5)

2025-09-16T22:34:49.313-07:00  INFO 28543 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 25 with PID 28543 (/Users/diegopacheco/Documents/git/diegopacheco/java-pocs/pocs/java-25-spring-boot-3.5/target/classes started by diegopacheco in /Users/diegopacheco/Documents/git/diegopacheco/java-pocs/pocs/java-25-spring-boot-3.5)
2025-09-16T22:34:49.314-07:00  INFO 28543 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2025-09-16T22:34:49.661-07:00  INFO 28543 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2025-09-16T22:34:49.665-07:00  INFO 28543 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-09-16T22:34:49.666-07:00  INFO 28543 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.44]
2025-09-16T22:34:49.679-07:00  INFO 28543 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-09-16T22:34:49.679-07:00  INFO 28543 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 350 ms
2025-09-16T22:34:49.847-07:00  INFO 28543 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2025-09-16T22:34:49.872-07:00  INFO 28543 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2025-09-16T22:34:49.881-07:00  INFO 28543 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 0.695 seconds (process running for 0.801)
Spring Boot 3.5.x working! 
```

### Test

```bash
curl -i http://localhost:8080/
```

```bash
❯ curl -i http://localhost:8080/
HTTP/1.1 200
Content-Type: text/plain;charset=UTF-8
Content-Length: 49
Date: Wed, 17 Sep 2025 05:36:36 GMT

Greetings from Spring Boot 3.5.5! Running Java 25
```