### Build
```bash
./mvnw clean install
```
### Result

run the application
```
/home/diego/.sdkman/candidates/java/21-amzn/bin/java -javaagent:/home/diego/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/lib/idea_rt.jar=45763:/home/diego/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-actuator-netty-shutdown/target/classes:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-webflux/3.3.2/spring-boot-starter-webflux-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter/3.3.2/spring-boot-starter-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot/3.3.2/spring-boot-3.3.2.jar:/home/diego/.m2/repository/org/springframework/spring-context/6.1.11/spring-context-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-aop/6.1.11/spring-aop-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-expression/6.1.11/spring-expression-6.1.11.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.3.2/spring-boot-autoconfigure-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.3.2/spring-boot-starter-logging-3.3.2.jar:/home/diego/.m2/repository/ch/qos/logback/logback-classic/1.5.6/logback-classic-1.5.6.jar:/home/diego/.m2/repository/ch/qos/logback/logback-core/1.5.6/logback-core-1.5.6.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.23.1/log4j-to-slf4j-2.23.1.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-api/2.23.1/log4j-api-2.23.1.jar:/home/diego/.m2/repository/org/slf4j/jul-to-slf4j/2.0.13/jul-to-slf4j-2.0.13.jar:/home/diego/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/home/diego/.m2/repository/org/yaml/snakeyaml/2.2/snakeyaml-2.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.3.2/spring-boot-starter-json-3.3.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.17.2/jackson-databind-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.17.2/jackson-annotations-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.17.2/jackson-core-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.17.2/jackson-datatype-jdk8-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.17.2/jackson-datatype-jsr310-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.17.2/jackson-module-parameter-names-2.17.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-reactor-netty/3.3.2/spring-boot-starter-reactor-netty-3.3.2.jar:/home/diego/.m2/repository/io/projectreactor/netty/reactor-netty-http/1.1.21/reactor-netty-http-1.1.21.jar:/home/diego/.m2/repository/io/netty/netty-codec-http/4.1.111.Final/netty-codec-http-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-common/4.1.111.Final/netty-common-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-buffer/4.1.111.Final/netty-buffer-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-transport/4.1.111.Final/netty-transport-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec/4.1.111.Final/netty-codec-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-handler/4.1.111.Final/netty-handler-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec-http2/4.1.111.Final/netty-codec-http2-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-resolver-dns/4.1.111.Final/netty-resolver-dns-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-resolver/4.1.111.Final/netty-resolver-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec-dns/4.1.111.Final/netty-codec-dns-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-resolver-dns-native-macos/4.1.111.Final/netty-resolver-dns-native-macos-4.1.111.Final-osx-x86_64.jar:/home/diego/.m2/repository/io/netty/netty-resolver-dns-classes-macos/4.1.111.Final/netty-resolver-dns-classes-macos-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-transport-native-epoll/4.1.111.Final/netty-transport-native-epoll-4.1.111.Final-linux-x86_64.jar:/home/diego/.m2/repository/io/netty/netty-transport-native-unix-common/4.1.111.Final/netty-transport-native-unix-common-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-transport-classes-epoll/4.1.111.Final/netty-transport-classes-epoll-4.1.111.Final.jar:/home/diego/.m2/repository/io/projectreactor/netty/reactor-netty-core/1.1.21/reactor-netty-core-1.1.21.jar:/home/diego/.m2/repository/io/netty/netty-handler-proxy/4.1.111.Final/netty-handler-proxy-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec-socks/4.1.111.Final/netty-codec-socks-4.1.111.Final.jar:/home/diego/.m2/repository/org/springframework/spring-web/6.1.11/spring-web-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-beans/6.1.11/spring-beans-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-webflux/6.1.11/spring-webflux-6.1.11.jar:/home/diego/.m2/repository/io/projectreactor/reactor-core/3.6.8/reactor-core-3.6.8.jar:/home/diego/.m2/repository/org/reactivestreams/reactive-streams/1.0.4/reactive-streams-1.0.4.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-actuator/3.3.2/spring-boot-starter-actuator-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-actuator-autoconfigure/3.3.2/spring-boot-actuator-autoconfigure-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-actuator/3.3.2/spring-boot-actuator-3.3.2.jar:/home/diego/.m2/repository/io/micrometer/micrometer-observation/1.13.2/micrometer-observation-1.13.2.jar:/home/diego/.m2/repository/io/micrometer/micrometer-commons/1.13.2/micrometer-commons-1.13.2.jar:/home/diego/.m2/repository/io/micrometer/micrometer-jakarta9/1.13.2/micrometer-jakarta9-1.13.2.jar:/home/diego/.m2/repository/io/micrometer/micrometer-core/1.13.2/micrometer-core-1.13.2.jar:/home/diego/.m2/repository/org/hdrhistogram/HdrHistogram/2.2.2/HdrHistogram-2.2.2.jar:/home/diego/.m2/repository/org/latencyutils/LatencyUtils/2.0.3/LatencyUtils-2.0.3.jar:/home/diego/.m2/repository/org/slf4j/slf4j-api/2.0.13/slf4j-api-2.0.13.jar:/home/diego/.m2/repository/org/springframework/spring-core/6.1.11/spring-core-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-jcl/6.1.11/spring-jcl-6.1.11.jar com.github.diegopacheco.sandboxspring.Application

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.2)

2024-08-09T23:50:20.061-07:00  INFO 564546 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 21 with PID 564546 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-actuator-netty-shutdown/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-actuator-netty-shutdown)
2024-08-09T23:50:20.066-07:00  INFO 564546 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2024-08-09T23:50:21.894-07:00  INFO 564546 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 15 endpoints beneath base path '/actuator'
2024-08-09T23:50:22.376-07:00  INFO 564546 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
2024-08-09T23:50:22.394-07:00  INFO 564546 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 2.861 seconds (process running for 3.385)
Spring Boot 3.3.x working! 
```
### Issue shutdown

```
❯ ./shutdown.sh
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 35

{"message":"Shutting down, bye..."}% 
```

### Result

```
/home/diego/.sdkman/candidates/java/21-amzn/bin/java -javaagent:/home/diego/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/lib/idea_rt.jar=45763:/home/diego/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-actuator-netty-shutdown/target/classes:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-webflux/3.3.2/spring-boot-starter-webflux-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter/3.3.2/spring-boot-starter-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot/3.3.2/spring-boot-3.3.2.jar:/home/diego/.m2/repository/org/springframework/spring-context/6.1.11/spring-context-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-aop/6.1.11/spring-aop-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-expression/6.1.11/spring-expression-6.1.11.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.3.2/spring-boot-autoconfigure-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.3.2/spring-boot-starter-logging-3.3.2.jar:/home/diego/.m2/repository/ch/qos/logback/logback-classic/1.5.6/logback-classic-1.5.6.jar:/home/diego/.m2/repository/ch/qos/logback/logback-core/1.5.6/logback-core-1.5.6.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.23.1/log4j-to-slf4j-2.23.1.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-api/2.23.1/log4j-api-2.23.1.jar:/home/diego/.m2/repository/org/slf4j/jul-to-slf4j/2.0.13/jul-to-slf4j-2.0.13.jar:/home/diego/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/home/diego/.m2/repository/org/yaml/snakeyaml/2.2/snakeyaml-2.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.3.2/spring-boot-starter-json-3.3.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.17.2/jackson-databind-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.17.2/jackson-annotations-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.17.2/jackson-core-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.17.2/jackson-datatype-jdk8-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.17.2/jackson-datatype-jsr310-2.17.2.jar:/home/diego/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.17.2/jackson-module-parameter-names-2.17.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-reactor-netty/3.3.2/spring-boot-starter-reactor-netty-3.3.2.jar:/home/diego/.m2/repository/io/projectreactor/netty/reactor-netty-http/1.1.21/reactor-netty-http-1.1.21.jar:/home/diego/.m2/repository/io/netty/netty-codec-http/4.1.111.Final/netty-codec-http-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-common/4.1.111.Final/netty-common-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-buffer/4.1.111.Final/netty-buffer-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-transport/4.1.111.Final/netty-transport-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec/4.1.111.Final/netty-codec-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-handler/4.1.111.Final/netty-handler-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec-http2/4.1.111.Final/netty-codec-http2-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-resolver-dns/4.1.111.Final/netty-resolver-dns-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-resolver/4.1.111.Final/netty-resolver-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec-dns/4.1.111.Final/netty-codec-dns-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-resolver-dns-native-macos/4.1.111.Final/netty-resolver-dns-native-macos-4.1.111.Final-osx-x86_64.jar:/home/diego/.m2/repository/io/netty/netty-resolver-dns-classes-macos/4.1.111.Final/netty-resolver-dns-classes-macos-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-transport-native-epoll/4.1.111.Final/netty-transport-native-epoll-4.1.111.Final-linux-x86_64.jar:/home/diego/.m2/repository/io/netty/netty-transport-native-unix-common/4.1.111.Final/netty-transport-native-unix-common-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-transport-classes-epoll/4.1.111.Final/netty-transport-classes-epoll-4.1.111.Final.jar:/home/diego/.m2/repository/io/projectreactor/netty/reactor-netty-core/1.1.21/reactor-netty-core-1.1.21.jar:/home/diego/.m2/repository/io/netty/netty-handler-proxy/4.1.111.Final/netty-handler-proxy-4.1.111.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec-socks/4.1.111.Final/netty-codec-socks-4.1.111.Final.jar:/home/diego/.m2/repository/org/springframework/spring-web/6.1.11/spring-web-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-beans/6.1.11/spring-beans-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-webflux/6.1.11/spring-webflux-6.1.11.jar:/home/diego/.m2/repository/io/projectreactor/reactor-core/3.6.8/reactor-core-3.6.8.jar:/home/diego/.m2/repository/org/reactivestreams/reactive-streams/1.0.4/reactive-streams-1.0.4.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-actuator/3.3.2/spring-boot-starter-actuator-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-actuator-autoconfigure/3.3.2/spring-boot-actuator-autoconfigure-3.3.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-actuator/3.3.2/spring-boot-actuator-3.3.2.jar:/home/diego/.m2/repository/io/micrometer/micrometer-observation/1.13.2/micrometer-observation-1.13.2.jar:/home/diego/.m2/repository/io/micrometer/micrometer-commons/1.13.2/micrometer-commons-1.13.2.jar:/home/diego/.m2/repository/io/micrometer/micrometer-jakarta9/1.13.2/micrometer-jakarta9-1.13.2.jar:/home/diego/.m2/repository/io/micrometer/micrometer-core/1.13.2/micrometer-core-1.13.2.jar:/home/diego/.m2/repository/org/hdrhistogram/HdrHistogram/2.2.2/HdrHistogram-2.2.2.jar:/home/diego/.m2/repository/org/latencyutils/LatencyUtils/2.0.3/LatencyUtils-2.0.3.jar:/home/diego/.m2/repository/org/slf4j/slf4j-api/2.0.13/slf4j-api-2.0.13.jar:/home/diego/.m2/repository/org/springframework/spring-core/6.1.11/spring-core-6.1.11.jar:/home/diego/.m2/repository/org/springframework/spring-jcl/6.1.11/spring-jcl-6.1.11.jar com.github.diegopacheco.sandboxspring.Application

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.2)

2024-08-09T23:50:20.061-07:00  INFO 564546 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 21 with PID 564546 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-actuator-netty-shutdown/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-actuator-netty-shutdown)
2024-08-09T23:50:20.066-07:00  INFO 564546 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2024-08-09T23:50:21.894-07:00  INFO 564546 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 15 endpoints beneath base path '/actuator'
2024-08-09T23:50:22.376-07:00  INFO 564546 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
2024-08-09T23:50:22.394-07:00  INFO 564546 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 2.861 seconds (process running for 3.385)
Spring Boot 3.3.x working! 
2024-08-09T23:50:49.869-07:00  INFO 564546 --- [       Thread-5] o.s.b.w.embedded.netty.GracefulShutdown  : Commencing graceful shutdown. Waiting for active requests to complete
2024-08-09T23:50:49.871-07:00  INFO 564546 --- [ netty-shutdown] o.s.b.w.embedded.netty.GracefulShutdown  : Graceful shutdown complete

Process finished with exit code 0
```

### CTRL + c has the same effect

```
❯ ./run.sh
[INFO] Scanning for projects...
[INFO] 
[INFO] --< com.github.diegopacheco.javapocs:spring-boot-3x-actuator-netty-shutdown >--
[INFO] Building spring-boot-3x-actuator-netty-shutdown 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ war ]---------------------------------
[INFO] 
[INFO] >>> spring-boot:3.3.2:run (default-cli) > test-compile @ spring-boot-3x-actuator-netty-shutdown >>>
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ spring-boot-3x-actuator-netty-shutdown ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] 
[INFO] --- compiler:3.13.0:compile (default-compile) @ spring-boot-3x-actuator-netty-shutdown ---
[INFO] Nothing to compile - all classes are up to date.
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ spring-boot-3x-actuator-netty-shutdown ---
[INFO] Copying 0 resource from src/test/resources to target/test-classes
[INFO] 
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ spring-boot-3x-actuator-netty-shutdown ---
[INFO] Nothing to compile - all classes are up to date.
[INFO] 
[INFO] <<< spring-boot:3.3.2:run (default-cli) < test-compile @ spring-boot-3x-actuator-netty-shutdown <<<
[INFO] 
[INFO] 
[INFO] --- spring-boot:3.3.2:run (default-cli) @ spring-boot-3x-actuator-netty-shutdown ---
[INFO] Attaching agents: []

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.2)

2024-08-09T23:52:33.990-07:00  INFO 566140 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 21 with PID 566140 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-actuator-netty-shutdown/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-actuator-netty-shutdown)
2024-08-09T23:52:33.993-07:00  INFO 566140 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2024-08-09T23:52:35.097-07:00  INFO 566140 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 15 endpoints beneath base path '/actuator'
2024-08-09T23:52:35.484-07:00  INFO 566140 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
2024-08-09T23:52:35.496-07:00  INFO 566140 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 1.79 seconds (process running for 2.029)
Spring Boot 3.3.x working! 
^C2024-08-09T23:52:37.222-07:00  INFO 566140 --- [ionShutdownHook] o.s.b.w.embedded.netty.GracefulShutdown  : Commencing graceful shutdown. Waiting for active requests to complete
2024-08-09T23:52:37.223-07:00  INFO 566140 --- [ netty-shutdown] o.s.b.w.embedded.netty.GracefulShutdown  : Graceful shutdown complete
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  7.119 s
[INFO] Finished at: 2024-08-09T23:52:39-07:00
[INFO] ------------------------------------------------------------------------

```