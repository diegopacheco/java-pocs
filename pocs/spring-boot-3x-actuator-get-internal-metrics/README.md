### Build
```bash
./mvnw clean install
```
### Run

```
/home/diego/.sdkman/candidates/java/22.0.1-amzn/bin/java -javaagent:/home/diego/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/lib/idea_rt.jar=44563:/home/diego/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-actuator-get-internal-metrics/target/classes:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-web/3.3.2/spring-boot-starter-web-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter/3.3.2/spring-boot-starter-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot/3.3.2/spring-boot-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.3.2/spring-boot-autoconfigure-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.3.2/spring-boot-starter-logging-3.3.2.jar:/home/diego/.m2/repository/ch/qos/logback/logback-classic/1.5.6/logback-classic-1.5.6.jar:/home/diego/.m2/repository/ch/qos/logback/logback-core/1.5.6/logback-core-1.5.6.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.23.1/log4j-to-slf4j-2.23.1.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-api/2.23.1/log4j-api-2.23.1.jar:/home/diego/.m2/repository/org/slf4j/jul-to-slf4j/2.0.13/jul-to-slf4j-2.0.13.jar:/home/diego/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/home/diego/.m2/repository/org/yaml/snakeyaml/2.2/snakeyaml-2.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.3.2/spring-boot-starter-json-3.3.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.17.2/jackson-databind-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.17.2/jackson-annotations-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.17.2/jackson-core-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.17.2/jackson-datatype-jdk8-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.17.2/jackson-datatype-jsr310-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.17.2/jackson-module-parameter-names-2.17.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/3.3.2/spring-boot-starter-tomcat-3.3.2.jar:/home/diego/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/10.1.26/tomcat-embed-core-10.1.26.jar:/home/diego/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/10.1.26/tomcat-embed-el-10.1.26.jar:/home/diego/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/10.1.26/tomcat-embed-websocket-10.1.26.jar:/home/diego/.m2/repository/org/springframework/spring-web/6.1.11/spring-web-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-beans/6.1.11/spring-beans-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-webmvc/6.1.11/spring-webmvc-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-aop/6.1.11/spring-aop-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-context/6.1.11/spring-context-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-expression/6.1.11/spring-expression-6.1.11.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-actuator/3.3.2/spring-boot-starter-actuator-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-actuator-autoconfigure/3.3.2/spring-boot-actuator-autoconfigure-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-actuator/3.3.2/spring-boot-actuator-3.3.2.jar:/home/diego/.m2/repository/io/micrometer/micrometer-observation/1.13.2/micrometer-observation-1.13.2.jar:/home/diego/.m2/repository/io/micrometer/micrometer-commons/1.13.2/micrometer-commons-1.13.2.jar:/home/diego/.m2/repository/io/micrometer/micrometer-jakarta9/1.13.2/micrometer-jakarta9-1.13.2.jar:/home/diego/.m2/repository/io/micrometer/micrometer-core/1.13.2/micrometer-core-1.13.2.jar:/home/diego/.m2/repository/org/hdrhistogram/HdrHistogram/2.2.2/HdrHistogram-2.2.2.jar:/home/diego/.m2/repository/org/latencyutils/LatencyUtils/2.0.3/LatencyUtils-2.0.3.jar:/home/diego/.m2/repository/org/slf4j/slf4j-api/2.0.13/slf4j-api-2.0.13.jar:/home/diego/.m2/repository/org/springframework/spring-core/6.1.11/spring-core-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-jcl/6.1.11/spring-jcl-6.1.11.jar com.github.diegopacheco.sandboxspring.Application

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.2)

2024-08-10T01:07:24.900-07:00  INFO 20464 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 22.0.1 with PID 20464 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-actuator-get-internal-metrics/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-actuator-get-internal-metrics)
2024-08-10T01:07:24.904-07:00  INFO 20464 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2024-08-10T01:07:26.183-07:00  INFO 20464 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-08-10T01:07:26.199-07:00  INFO 20464 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-08-10T01:07:26.200-07:00  INFO 20464 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.26]
2024-08-10T01:07:26.255-07:00  INFO 20464 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-08-10T01:07:26.256-07:00  INFO 20464 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1293 ms
2024-08-10T01:07:26.879-07:00  INFO 20464 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2024-08-10T01:07:26.950-07:00  INFO 20464 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2024-08-10T01:07:26.969-07:00  INFO 20464 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 2.559 seconds (process running for 3.046)
Spring Boot 3.3.x working! 
2024-08-10T01:07:29.021-07:00  INFO 20464 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2024-08-10T01:07:29.021-07:00  INFO 20464 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2024-08-10T01:07:29.023-07:00  INFO 20464 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms
```

### Test
```bash
curl http://localhost:8080/metrics
```

### Result

```
metric: jvm.buffer.memory.used
value: 9003016.0
metric: jvm.threads.states
value: 0.0
metric: process.uptime
value: 33.712
metric: jvm.memory.used
value: 5191272.0
metric: jvm.threads.states
value: 0.0
metric: system.load.average.1m
value: 1.86181640625
metric: jvm.memory.used
value: 5191272.0
metric: jvm.buffer.count
value: 0.0
metric: logback.events
value: 0.0
metric: jvm.memory.committed
value: 4.194304E7
metric: jvm.memory.used
value: 5193624.0
metric: executor.queue.remaining
value: 2.147483647E9
metric: jvm.buffer.total.capacity
value: 9003015.0
metric: jvm.memory.committed
value: 4.194304E7
metric: executor.pool.size
value: 0.0
metric: jvm.memory.max
value: -1.0
metric: jvm.gc.pause
type: TIMER - ignored
metric: system.cpu.usage
value: 0.0
metric: jvm.threads.live
value: 14.0
metric: jvm.classes.unloaded
metric: jvm.memory.committed
value: 4.194304E7
metric: jvm.classes.loaded
value: 8799.0
metric: jvm.threads.peak
value: 14.0
metric: process.cpu.time
metric: http.server.requests
type: TIMER - ignored
metric: jvm.memory.max
value: -1.0
metric: jvm.info
value: 1.0
metric: jvm.memory.committed
value: 4.194304E7
metric: jvm.gc.pause
type: TIMER - ignored
metric: http.server.requests.active
type: LONG_TASK_TIMER - ignored
metric: jvm.gc.overhead
value: 6.575177737050969E-4
metric: logback.events
value: 0.0
metric: jvm.gc.concurrent.phase.time
type: TIMER - ignored
metric: logback.events
value: 0.0
metric: jvm.gc.memory.promoted
value: 8713200.0
metric: jvm.memory.max
value: -1.0
metric: jvm.threads.started
metric: jvm.threads.states
value: 0.0
metric: jvm.buffer.count
value: 0.0
metric: executor.completed
metric: jvm.memory.used
value: 5197864.0
metric: executor.pool.max
value: 2.147483647E9
metric: application.started.time
value: 3.141
metric: jvm.gc.memory.allocated
value: 6.7108864E7
metric: logback.events
value: 0.0
metric: jvm.memory.max
value: -1.0
metric: jvm.memory.usage.after.gc
value: 9.684997901060337E-4
metric: disk.free
value: 2.97592336384E11
metric: jvm.memory.used
value: 5197864.0
metric: jvm.memory.used
value: 5197864.0
metric: jvm.buffer.total.capacity
value: 9003015.0
metric: jvm.gc.max.data.size
value: 1.681915904E10
metric: jvm.buffer.memory.used
value: 9003016.0
metric: jvm.memory.used
value: 5197864.0
metric: jvm.memory.max
value: -1.0
metric: system.cpu.count
value: 12.0
metric: jvm.memory.max
value: -1.0
metric: application.ready.time
value: 3.146
metric: executor.pool.core
value: 8.0
metric: process.start.time
value: 1.723277781067E9
metric: http.server.requests
type: TIMER - ignored
metric: jvm.buffer.count
value: 0.0
metric: jvm.buffer.memory.used
value: 9003016.0
metric: jvm.threads.daemon
value: 12.0
metric: process.files.max
value: 65535.0
metric: jvm.compilation.time
metric: jvm.threads.states
value: 0.0
metric: jvm.buffer.total.capacity
value: 9003015.0
metric: jvm.memory.committed
value: 4.194304E7
metric: jvm.memory.committed
value: 4.194304E7
metric: jvm.threads.states
value: 0.0
metric: jvm.memory.used
value: 5197864.0
metric: jvm.memory.committed
value: 4.194304E7
metric: disk.total
value: 9.83358451712E11
metric: jvm.memory.max
value: -1.0
metric: executor.active
value: 0.0
metric: jvm.memory.max
value: -1.0
metric: jvm.threads.states
value: 0.0
metric: jvm.memory.committed
value: 4.194304E7
metric: process.files.open
value: 108.0
metric: jvm.gc.live.data.size
value: 0.0
metric: executor.queued
value: 0.0
metric: logback.events
value: 0.0
metric: process.cpu.usage
value: 0.125
```