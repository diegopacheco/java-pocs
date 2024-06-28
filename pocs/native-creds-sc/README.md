### Install SDKMan and GraalVM
```bash
curl -s "https://get.sdkman.io" | bash

sdk install java 21-graalce
sdk use java 21-graalce
```

### Build
```bash
./mvnw clean install
```

### Build Native
```bash
./build-native.sh
```

### Boot Up
```
/home/diego/.sdkman/candidates/java/22.0.1-amzn/bin/java -agentlib:jdwp=transport=dt_socket,address=127.0.0.1:60633,suspend=y,server=n -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/classes:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-webflux/3.3.0/spring-boot-starter-webflux-3.3.0.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter/3.3.0/spring-boot-starter-3.3.0.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot/3.3.0/spring-boot-3.3.0.jar:/home/diego/.m2/repository/org/springframework/spring-context/6.1.8/spring-context-6.1.8.jar:/home/diego/.m2/repository/org/springframework/spring-aop/6.1.8/spring-aop-6.1.8.jar:/home/diego/.m2/repository/org/springframework/spring-expression/6.1.8/spring-expression-6.1.8.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.3.0/spring-boot-autoconfigure-3.3.0.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.3.0/spring-boot-starter-logging-3.3.0.jar:/home/diego/.m2/repository/ch/qos/logback/logback-classic/1.5.6/logback-classic-1.5.6.jar:/home/diego/.m2/repository/ch/qos/logback/logback-core/1.5.6/logback-core-1.5.6.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.23.1/log4j-to-slf4j-2.23.1.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-api/2.23.1/log4j-api-2.23.1.jar:/home/diego/.m2/repository/org/slf4j/jul-to-slf4j/2.0.13/jul-to-slf4j-2.0.13.jar:/home/diego/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/home/diego/.m2/repository/org/yaml/snakeyaml/2.2/snakeyaml-2.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.3.0/spring-boot-starter-json-3.3.0.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.17.1/jackson-databind-2.17.1.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.17.1/jackson-annotations-2.17.1.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.17.1/jackson-core-2.17.1.jar:/home/diego/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.17.1/jackson-datatype-jdk8-2.17.1.jar:/home/diego/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.17.1/jackson-datatype-jsr310-2.17.1.jar:/home/diego/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.17.1/jackson-module-parameter-names-2.17.1.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-reactor-netty/3.3.0/spring-boot-starter-reactor-netty-3.3.0.jar:/home/diego/.m2/repository/io/projectreactor/netty/reactor-netty-http/1.1.19/reactor-netty-http-1.1.19.jar:/home/diego/.m2/repository/io/netty/netty-codec-http/4.1.110.Final/netty-codec-http-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-common/4.1.110.Final/netty-common-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-buffer/4.1.110.Final/netty-buffer-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-transport/4.1.110.Final/netty-transport-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec/4.1.110.Final/netty-codec-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-handler/4.1.110.Final/netty-handler-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec-http2/4.1.110.Final/netty-codec-http2-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-resolver-dns/4.1.110.Final/netty-resolver-dns-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-resolver/4.1.110.Final/netty-resolver-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec-dns/4.1.110.Final/netty-codec-dns-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-resolver-dns-native-macos/4.1.110.Final/netty-resolver-dns-native-macos-4.1.110.Final-osx-x86_64.jar:/home/diego/.m2/repository/io/netty/netty-resolver-dns-classes-macos/4.1.110.Final/netty-resolver-dns-classes-macos-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-transport-native-epoll/4.1.110.Final/netty-transport-native-epoll-4.1.110.Final-linux-x86_64.jar:/home/diego/.m2/repository/io/netty/netty-transport-native-unix-common/4.1.110.Final/netty-transport-native-unix-common-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-transport-classes-epoll/4.1.110.Final/netty-transport-classes-epoll-4.1.110.Final.jar:/home/diego/.m2/repository/io/projectreactor/netty/reactor-netty-core/1.1.19/reactor-netty-core-1.1.19.jar:/home/diego/.m2/repository/io/netty/netty-handler-proxy/4.1.110.Final/netty-handler-proxy-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec-socks/4.1.110.Final/netty-codec-socks-4.1.110.Final.jar:/home/diego/.m2/repository/org/springframework/spring-web/6.1.8/spring-web-6.1.8.jar:/home/diego/.m2/repository/org/springframework/spring-beans/6.1.8/spring-beans-6.1.8.jar:/home/diego/.m2/repository/org/springframework/spring-webflux/6.1.8/spring-webflux-6.1.8.jar:/home/diego/.m2/repository/io/projectreactor/reactor-core/3.6.6/reactor-core-3.6.6.jar:/home/diego/.m2/repository/org/reactivestreams/reactive-streams/1.0.4/reactive-streams-1.0.4.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-actuator/3.3.0/spring-boot-starter-actuator-3.3.0.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-actuator-autoconfigure/3.3.0/spring-boot-actuator-autoconfigure-3.3.0.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-actuator/3.3.0/spring-boot-actuator-3.3.0.jar:/home/diego/.m2/repository/io/micrometer/micrometer-observation/1.13.0/micrometer-observation-1.13.0.jar:/home/diego/.m2/repository/io/micrometer/micrometer-commons/1.13.0/micrometer-commons-1.13.0.jar:/home/diego/.m2/repository/io/micrometer/micrometer-jakarta9/1.13.0/micrometer-jakarta9-1.13.0.jar:/home/diego/.m2/repository/io/micrometer/micrometer-core/1.13.0/micrometer-core-1.13.0.jar:/home/diego/.m2/repository/org/hdrhistogram/HdrHistogram/2.2.1/HdrHistogram-2.2.1.jar:/home/diego/.m2/repository/org/latencyutils/LatencyUtils/2.0.3/LatencyUtils-2.0.3.jar:/home/diego/.m2/repository/org/slf4j/slf4j-api/2.0.13/slf4j-api-2.0.13.jar:/home/diego/.m2/repository/org/springframework/spring-core/6.1.8/spring-core-6.1.8.jar:/home/diego/.m2/repository/org/springframework/spring-jcl/6.1.8/spring-jcl-6.1.8.jar:/home/diego/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/lib/idea_rt.jar com.github.diegopacheco.sandboxspring.Application
Connected to the target VM, address: '127.0.0.1:60633', transport: 'socket'
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.0)

2024-06-27T23:57:11.329-07:00  INFO 3656072 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 22.0.1 with PID 3656072 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc)
2024-06-27T23:57:11.334-07:00  INFO 3656072 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2024-06-27T23:57:13.116-07:00  INFO 3656072 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2024-06-27T23:57:13.657-07:00  INFO 3656072 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
2024-06-27T23:57:13.677-07:00  INFO 3656072 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 2.883 seconds (process running for 3.344)
```

### Test
```bash
❯ ./test.sh
Calling encryption. Result: 2YuPeXOEGfM33mgjKLlj2w==
Calling decryption. Result: SpringRocks
``` 

### Build Native Output
```
❯ ./build-native.sh
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------< com.github.diegopacheco.javapocs:native-creds-sc >----------
[INFO] Building native-creds-sc 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ war ]---------------------------------
[INFO] 
[INFO] --- clean:3.3.2:clean (default-clean) @ native-creds-sc ---
[INFO] Deleting /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target
[INFO] 
[INFO] --- native:0.10.2:add-reachability-metadata (add-reachability-metadata) @ native-creds-sc ---
[INFO] Downloaded GraalVM reachability metadata repository from file:/home/diego/.m2/repository/org/graalvm/buildtools/graalvm-reachability-metadata/0.10.2/graalvm-reachability-metadata-0.10.2-repository.zip
[INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.6]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.6]: Configuration directory is ch.qos.logback/logback-classic/1.4.9
[INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.17.1]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.17.1]: Configuration directory is com.fasterxml.jackson.core/jackson-databind/2.15.2
[INFO] [graalvm reachability metadata repository for io.netty:netty-codec-http:4.1.110.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-codec-http:4.1.110.Final]: Configuration directory is io.netty/netty-codec-http/4.1.80.Final
[INFO] [graalvm reachability metadata repository for io.netty:netty-common:4.1.110.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-common:4.1.110.Final]: Configuration directory is io.netty/netty-common/4.1.80.Final
[INFO] [graalvm reachability metadata repository for io.netty:netty-buffer:4.1.110.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-buffer:4.1.110.Final]: Configuration directory is io.netty/netty-buffer/4.1.80.Final
[INFO] [graalvm reachability metadata repository for io.netty:netty-transport:4.1.110.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-transport:4.1.110.Final]: Configuration directory is io.netty/netty-transport/4.1.80.Final
[INFO] [graalvm reachability metadata repository for io.netty:netty-handler:4.1.110.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-handler:4.1.110.Final]: Configuration directory is io.netty/netty-handler/4.1.80.Final
[INFO] [graalvm reachability metadata repository for io.netty:netty-codec-http2:4.1.110.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-codec-http2:4.1.110.Final]: Configuration directory is io.netty/netty-codec-http2/4.1.80.Final
[INFO] [graalvm reachability metadata repository for io.netty:netty-resolver-dns:4.1.110.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-resolver-dns:4.1.110.Final]: Configuration directory is io.netty/netty-resolver-dns/4.1.80.Final
[INFO] [graalvm reachability metadata repository for org.hdrhistogram:HdrHistogram:2.2.1]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for org.hdrhistogram:HdrHistogram:2.2.1]: Configuration directory is org.hdrhistogram/HdrHistogram/2.1.12
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ native-creds-sc ---
[INFO] Copying 0 resource from src/main/resources to target/classes
[INFO] Copying 2 resources from src/main/resources to target/classes
[INFO] 
[INFO] --- compiler:3.13.0:compile (default-compile) @ native-creds-sc ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 4 source files with javac [debug parameters release 21] to target/classes
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ native-creds-sc ---
[INFO] Copying 0 resource from src/test/resources to target/test-classes
[INFO] 
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ native-creds-sc ---
[INFO] Recompiling the module because of changed dependency.
[INFO] 
[INFO] --- surefire:3.2.5:test (default-test) @ native-creds-sc ---
[WARNING]  Parameter 'systemProperties' is deprecated: Use systemPropertyVariables instead.
[INFO] 
[INFO] --- spring-boot:3.3.0:process-aot (process-aot) @ native-creds-sc ---
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.0)

2024-06-28T00:10:48.655-07:00  INFO 3660652 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 21 with PID 3660652 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc)
2024-06-28T00:10:48.658-07:00  INFO 3660652 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
[INFO] 
[INFO] --- war:3.4.0:war (default-war) @ native-creds-sc ---
[INFO] Packaging webapp
[INFO] Assembling webapp [native-creds-sc] in [/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/native-creds-sc-1.0-SNAPSHOT]
[INFO] Processing war project
[INFO] Copying webapp resources [/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/src/main/webapp]
[INFO] Building war: /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/native-creds-sc-1.0-SNAPSHOT.war
[INFO] 
[INFO] --- spring-boot:3.3.0:repackage (repackage) @ native-creds-sc ---
[INFO] Replacing main artifact /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/native-creds-sc-1.0-SNAPSHOT.war with repackaged archive, adding nested dependencies in BOOT-INF/.
[INFO] The original artifact has been renamed to /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/native-creds-sc-1.0-SNAPSHOT.war.original
[INFO] 
[INFO] --- native:0.10.2:compile-no-fork (build-native) @ native-creds-sc ---
[INFO] Found GraalVM installation from JAVA_HOME variable.
[INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.6]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.6]: Configuration directory is ch.qos.logback/logback-classic/1.4.9
[INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.17.1]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.17.1]: Configuration directory is com.fasterxml.jackson.core/jackson-databind/2.15.2
[INFO] [graalvm reachability metadata repository for io.netty:netty-codec-http:4.1.110.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-codec-http:4.1.110.Final]: Configuration directory is io.netty/netty-codec-http/4.1.80.Final
[INFO] [graalvm reachability metadata repository for io.netty:netty-common:4.1.110.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-common:4.1.110.Final]: Configuration directory is io.netty/netty-common/4.1.80.Final
[INFO] [graalvm reachability metadata repository for io.netty:netty-buffer:4.1.110.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-buffer:4.1.110.Final]: Configuration directory is io.netty/netty-buffer/4.1.80.Final
[INFO] [graalvm reachability metadata repository for io.netty:netty-transport:4.1.110.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-transport:4.1.110.Final]: Configuration directory is io.netty/netty-transport/4.1.80.Final
[INFO] [graalvm reachability metadata repository for io.netty:netty-handler:4.1.110.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-handler:4.1.110.Final]: Configuration directory is io.netty/netty-handler/4.1.80.Final
[INFO] [graalvm reachability metadata repository for io.netty:netty-codec-http2:4.1.110.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-codec-http2:4.1.110.Final]: Configuration directory is io.netty/netty-codec-http2/4.1.80.Final
[INFO] [graalvm reachability metadata repository for io.netty:netty-resolver-dns:4.1.110.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-resolver-dns:4.1.110.Final]: Configuration directory is io.netty/netty-resolver-dns/4.1.80.Final
[INFO] [graalvm reachability metadata repository for org.hdrhistogram:HdrHistogram:2.2.1]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for org.hdrhistogram:HdrHistogram:2.2.1]: Configuration directory is org.hdrhistogram/HdrHistogram/2.1.12
[INFO] Executing: /home/diego/.sdkman/candidates/java/21-graalce/bin/native-image -cp /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/classes:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-webflux/3.3.0/spring-boot-starter-webflux-3.3.0.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter/3.3.0/spring-boot-starter-3.3.0.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot/3.3.0/spring-boot-3.3.0.jar:/home/diego/.m2/repository/org/springframework/spring-context/6.1.8/spring-context-6.1.8.jar:/home/diego/.m2/repository/org/springframework/spring-aop/6.1.8/spring-aop-6.1.8.jar:/home/diego/.m2/repository/org/springframework/spring-expression/6.1.8/spring-expression-6.1.8.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.3.0/spring-boot-autoconfigure-3.3.0.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.3.0/spring-boot-starter-logging-3.3.0.jar:/home/diego/.m2/repository/ch/qos/logback/logback-classic/1.5.6/logback-classic-1.5.6.jar:/home/diego/.m2/repository/ch/qos/logback/logback-core/1.5.6/logback-core-1.5.6.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.23.1/log4j-to-slf4j-2.23.1.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-api/2.23.1/log4j-api-2.23.1.jar:/home/diego/.m2/repository/org/slf4j/jul-to-slf4j/2.0.13/jul-to-slf4j-2.0.13.jar:/home/diego/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/home/diego/.m2/repository/org/yaml/snakeyaml/2.2/snakeyaml-2.2.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.3.0/spring-boot-starter-json-3.3.0.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.17.1/jackson-databind-2.17.1.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.17.1/jackson-annotations-2.17.1.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.17.1/jackson-core-2.17.1.jar:/home/diego/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.17.1/jackson-datatype-jdk8-2.17.1.jar:/home/diego/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.17.1/jackson-datatype-jsr310-2.17.1.jar:/home/diego/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.17.1/jackson-module-parameter-names-2.17.1.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-reactor-netty/3.3.0/spring-boot-starter-reactor-netty-3.3.0.jar:/home/diego/.m2/repository/io/projectreactor/netty/reactor-netty-http/1.1.19/reactor-netty-http-1.1.19.jar:/home/diego/.m2/repository/io/netty/netty-codec-http/4.1.110.Final/netty-codec-http-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-common/4.1.110.Final/netty-common-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-buffer/4.1.110.Final/netty-buffer-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-transport/4.1.110.Final/netty-transport-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec/4.1.110.Final/netty-codec-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-handler/4.1.110.Final/netty-handler-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec-http2/4.1.110.Final/netty-codec-http2-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-resolver-dns/4.1.110.Final/netty-resolver-dns-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-resolver/4.1.110.Final/netty-resolver-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec-dns/4.1.110.Final/netty-codec-dns-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-resolver-dns-native-macos/4.1.110.Final/netty-resolver-dns-native-macos-4.1.110.Final-osx-x86_64.jar:/home/diego/.m2/repository/io/netty/netty-resolver-dns-classes-macos/4.1.110.Final/netty-resolver-dns-classes-macos-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-transport-native-epoll/4.1.110.Final/netty-transport-native-epoll-4.1.110.Final-linux-x86_64.jar:/home/diego/.m2/repository/io/netty/netty-transport-native-unix-common/4.1.110.Final/netty-transport-native-unix-common-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-transport-classes-epoll/4.1.110.Final/netty-transport-classes-epoll-4.1.110.Final.jar:/home/diego/.m2/repository/io/projectreactor/netty/reactor-netty-core/1.1.19/reactor-netty-core-1.1.19.jar:/home/diego/.m2/repository/io/netty/netty-handler-proxy/4.1.110.Final/netty-handler-proxy-4.1.110.Final.jar:/home/diego/.m2/repository/io/netty/netty-codec-socks/4.1.110.Final/netty-codec-socks-4.1.110.Final.jar:/home/diego/.m2/repository/org/springframework/spring-web/6.1.8/spring-web-6.1.8.jar:/home/diego/.m2/repository/org/springframework/spring-beans/6.1.8/spring-beans-6.1.8.jar:/home/diego/.m2/repository/org/springframework/spring-webflux/6.1.8/spring-webflux-6.1.8.jar:/home/diego/.m2/repository/io/projectreactor/reactor-core/3.6.6/reactor-core-3.6.6.jar:/home/diego/.m2/repository/org/reactivestreams/reactive-streams/1.0.4/reactive-streams-1.0.4.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-actuator/3.3.0/spring-boot-starter-actuator-3.3.0.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-actuator-autoconfigure/3.3.0/spring-boot-actuator-autoconfigure-3.3.0.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-actuator/3.3.0/spring-boot-actuator-3.3.0.jar:/home/diego/.m2/repository/io/micrometer/micrometer-observation/1.13.0/micrometer-observation-1.13.0.jar:/home/diego/.m2/repository/io/micrometer/micrometer-commons/1.13.0/micrometer-commons-1.13.0.jar:/home/diego/.m2/repository/io/micrometer/micrometer-jakarta9/1.13.0/micrometer-jakarta9-1.13.0.jar:/home/diego/.m2/repository/io/micrometer/micrometer-core/1.13.0/micrometer-core-1.13.0.jar:/home/diego/.m2/repository/org/hdrhistogram/HdrHistogram/2.2.1/HdrHistogram-2.2.1.jar:/home/diego/.m2/repository/org/latencyutils/LatencyUtils/2.0.3/LatencyUtils-2.0.3.jar:/home/diego/.m2/repository/org/slf4j/slf4j-api/2.0.13/slf4j-api-2.0.13.jar:/home/diego/.m2/repository/org/springframework/spring-core/6.1.8/spring-core-6.1.8.jar:/home/diego/.m2/repository/org/springframework/spring-jcl/6.1.8/spring-jcl-6.1.8.jar --no-fallback -o /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/native-creds-sc -H:ConfigurationFileDirectories=/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/graalvm-reachability-metadata/b477865f26a269b9b773642a947f92b4833d8c18/io.netty/netty-handler/4.1.80.Final,/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/graalvm-reachability-metadata/b477865f26a269b9b773642a947f92b4833d8c18/com.fasterxml.jackson.core/jackson-databind/2.15.2,/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/graalvm-reachability-metadata/b477865f26a269b9b773642a947f92b4833d8c18/io.netty/netty-buffer/4.1.80.Final,/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/graalvm-reachability-metadata/b477865f26a269b9b773642a947f92b4833d8c18/io.netty/netty-codec-http2/4.1.80.Final,/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/graalvm-reachability-metadata/b477865f26a269b9b773642a947f92b4833d8c18/org.hdrhistogram/HdrHistogram/2.1.12,/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/graalvm-reachability-metadata/b477865f26a269b9b773642a947f92b4833d8c18/ch.qos.logback/logback-classic/1.4.9,/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/graalvm-reachability-metadata/b477865f26a269b9b773642a947f92b4833d8c18/io.netty/netty-codec-http/4.1.80.Final,/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/graalvm-reachability-metadata/b477865f26a269b9b773642a947f92b4833d8c18/io.netty/netty-transport/4.1.80.Final,/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/graalvm-reachability-metadata/b477865f26a269b9b773642a947f92b4833d8c18/io.netty/netty-resolver-dns/4.1.80.Final,/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/graalvm-reachability-metadata/b477865f26a269b9b773642a947f92b4833d8c18/io.netty/netty-common/4.1.80.Final --exclude-config \Q/home/diego/.m2/repository/io/netty/netty-codec-http/4.1.110.Final/netty-codec-http-4.1.110.Final.jar\E ^/META-INF/native-image/ --exclude-config \Q/home/diego/.m2/repository/io/netty/netty-common/4.1.110.Final/netty-common-4.1.110.Final.jar\E ^/META-INF/native-image/ --exclude-config \Q/home/diego/.m2/repository/io/netty/netty-buffer/4.1.110.Final/netty-buffer-4.1.110.Final.jar\E ^/META-INF/native-image/ --exclude-config \Q/home/diego/.m2/repository/io/netty/netty-transport/4.1.110.Final/netty-transport-4.1.110.Final.jar\E ^/META-INF/native-image/ --exclude-config \Q/home/diego/.m2/repository/io/netty/netty-handler/4.1.110.Final/netty-handler-4.1.110.Final.jar\E ^/META-INF/native-image/ --exclude-config \Q/home/diego/.m2/repository/io/netty/netty-codec-http2/4.1.110.Final/netty-codec-http2-4.1.110.Final.jar\E ^/META-INF/native-image/ --exclude-config \Q/home/diego/.m2/repository/io/netty/netty-resolver-dns/4.1.110.Final/netty-resolver-dns-4.1.110.Final.jar\E ^/META-INF/native-image/
========================================================================================================================
GraalVM Native Image: Generating 'native-creds-sc' (executable)...
========================================================================================================================
[1/8] Initializing...                                                                                    (7.8s @ 0.22GB)
 Java version: 21+35, vendor version: GraalVM CE 21+35.1
 Graal compiler: optimization level: 2, target machine: x86-64-v3
 C compiler: gcc (linux, x86_64, 11.4.0)
 Garbage collector: Serial GC (max heap size: 80% of RAM)
 2 user-specific feature(s):
 - com.oracle.svm.thirdparty.gson.GsonFeature
 - org.springframework.aot.nativex.feature.PreComputeFieldFeature
------------------------------------------------------------------------------------------------------------------------
Build resources:
 - 26.49GB of memory (42.3% of 62.65GB system memory, determined at start)
 - 12 thread(s) (100.0% of 12 available processor(s), determined at start)
SLF4J(W): No SLF4J providers were found.
SLF4J(W): Defaulting to no-operation (NOP) logger implementation
SLF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details.
[2/8] Performing analysis...  [******]                                                                  (73.5s @ 1.80GB)
   19,464 reachable types   (89.5% of   21,738 total)
   29,272 reachable fields  (61.3% of   47,749 total)
   92,672 reachable methods (61.6% of  150,521 total)
    6,275 types,   642 fields, and 6,799 methods registered for reflection
       86 types,    82 fields, and    65 methods registered for JNI access
        4 native libraries: dl, pthread, rt, z
[3/8] Building universe...                                                                               (9.5s @ 2.06GB)
[4/8] Parsing methods...      [***]                                                                      (6.7s @ 2.10GB)
[5/8] Inlining methods...     [***]                                                                      (4.9s @ 2.24GB)
[6/8] Compiling methods...    [********]                                                                (64.9s @ 2.14GB)
[7/8] Layouting methods...    [***]                                                                     (10.4s @ 1.72GB)
[8/8] Creating image...       [***]                                                                     (10.4s @ 2.46GB)
  40.64MB (48.16%) for code area:    60,386 compilation units
  40.01MB (47.41%) for image heap:  409,597 objects and 240 resources
   3.74MB ( 4.43%) for other data
  84.39MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 origins of code area:                                Top 10 object types in image heap:
  14.53MB java.base                                           12.61MB byte[] for code metadata
   3.72MB java.xml                                             6.03MB byte[] for java.lang.String
   2.07MB jackson-databind-2.17.1.jar                          4.77MB java.lang.Class
   1.66MB spring-core-6.1.8.jar                                3.89MB java.lang.String
   1.56MB svm.jar (Native Image)                               1.63MB com.oracle.svm.core.hub.DynamicHubCompanion
   1.38MB reactor-core-3.6.6.jar                               1.18MB byte[] for reflection metadata
   1.23MB spring-boot-3.3.0.jar                                1.01MB byte[] for embedded resources
1017.73kB spring-web-6.1.8.jar                               794.67kB byte[] for general heap data
 939.02kB spring-beans-6.1.8.jar                             788.52kB java.lang.String[]
 765.72kB jackson-core-2.17.1.jar                            700.20kB c.o.svm.core.hub.DynamicHub$ReflectionMetadata
  11.42MB for 115 more packages                                6.65MB for 4103 more object types
------------------------------------------------------------------------------------------------------------------------
Recommendations:
 INIT: Adopt '-H:+StrictImageHeap' to prepare for the next GraalVM release.
 HEAP: Set max heap for improved and more predictable memory usage.
 CPU:  Enable more CPU features with '-march=native' for improved performance.
------------------------------------------------------------------------------------------------------------------------
                       14.9s (7.8% of total time) in 175 GCs | Peak RSS: 5.17GB | CPU load: 8.78
------------------------------------------------------------------------------------------------------------------------
Produced artifacts:
 /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/native-creds-sc (executable)
========================================================================================================================
Finished generating 'native-creds-sc' in 3m 9s.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  03:22 min
[INFO] Finished at: 2024-06-28T00:14:07-07:00
[INFO] ------------------------------------------------------------------------

```
```
❯ ls -lsa -h target
total 131M
4,0K drwxrwxr-x 11 diego diego 4,0K jun 28 00:14 .
4,0K drwxrwxr-x  6 diego diego 4,0K jun 28 00:14 ..
4,0K drwxrwxr-x  5 diego diego 4,0K jun 28 00:10 classes
4,0K drwxrwxr-x  3 diego diego 4,0K jun 28 00:10 generated-sources
4,0K drwxrwxr-x  3 diego diego 4,0K jun 28 00:10 generated-test-sources
4,0K drwxrwxr-x  3 diego diego 4,0K jun 28 00:10 graalvm-reachability-metadata
4,0K drwxrwxr-x  2 diego diego 4,0K jun 28 00:10 maven-archiver
4,0K drwxrwxr-x  3 diego diego 4,0K jun 28 00:10 maven-status
 85M -rwxrwxr-x  1 diego diego  85M jun 28 00:14 native-creds-sc
4,0K drwxrwxr-x  4 diego diego 4,0K jun 28 00:10 native-creds-sc-1.0-SNAPSHOT
 25M -rw-rw-r--  1 diego diego  25M jun 28 00:10 native-creds-sc-1.0-SNAPSHOT.war
 22M -rw-rw-r--  1 diego diego  22M jun 28 00:10 native-creds-sc-1.0-SNAPSHOT.war.original
4,0K drwxrwxr-x  3 diego diego 4,0K jun 28 00:10 spring-aot
4,0K drwxrwxr-x  2 diego diego 4,0K jun 28 00:10 test-classes
```

### Run native boot up
```
❯ ./run-native.sh
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.0)

2024-06-28T00:17:15.225-07:00  INFO 3662317 --- [           main] c.g.d.sandboxspring.Application          : Starting AOT-processed Application using Java 21 with PID 3662317 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc/target/native-creds-sc started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/native-creds-sc)
2024-06-28T00:17:15.225-07:00  INFO 3662317 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2024-06-28T00:17:15.290-07:00  INFO 3662317 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2024-06-28T00:17:15.321-07:00  INFO 3662317 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
2024-06-28T00:17:15.322-07:00  INFO 3662317 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 0.116 seconds (process running for 0.123)
```
```
❯ ./test.sh
Calling encryption. Result: IRKwUdOejKXhsQqDD+1QYA==
Calling decryption. Result: SpringRocks
```

### Build container using native image
```
 ./build-docker.sh
[+] Building 0.5s (14/14) FINISHED                                                                                                                            docker:default
 => [internal] load build definition from Dockerfile                                                                                                                    0.0s
 => => transferring dockerfile: 1.51kB                                                                                                                                  0.0s
 => [internal] load metadata for registry.access.redhat.com/ubi9-micro:9.2                                                                                              0.4s
 => [internal] load metadata for registry.access.redhat.com/ubi9-minimal:9.2                                                                                            0.3s
 => [internal] load .dockerignore                                                                                                                                       0.0s
 => => transferring context: 2B                                                                                                                                         0.0s
 => [scratch 1/1] FROM registry.access.redhat.com/ubi9-micro:9.2@sha256:d14ac3ae12148f838511d08261e1569fb2a54da4c54a817aea7f16c1c9078f0b                                0.0s
 => [internal] load build context                                                                                                                                       0.0s
 => => transferring context: 72B                                                                                                                                        0.0s
 => [ubi 1/1] FROM registry.access.redhat.com/ubi9-minimal:9.2@sha256:c8c7a06ce1c5fa23c1cbd7a0fd891eacd099bc232aa9985ddb183cfe98d1deaf                                  0.0s
 => CACHED [stage-3 1/6] COPY --from=ubi /usr/lib64/libgcc_s.so.1 /usr/lib64/libgcc_s.so.1                                                                              0.0s
 => CACHED [stage-3 2/6] COPY --from=ubi /usr/lib64/libstdc++.so.6 /usr/lib64/libstdc++.so.6                                                                            0.0s
 => CACHED [stage-3 3/6] COPY --from=ubi /usr/lib64/libz.so.1 /usr/lib64/libz.so.1                                                                                      0.0s
 => CACHED [stage-3 4/6] WORKDIR /work/                                                                                                                                 0.0s
 => CACHED [stage-3 5/6] RUN chown 1001 /work     && chmod "g+rwX" /work     && chown 1001:root /work                                                                   0.0s
 => CACHED [stage-3 6/6] COPY --chown=1001:root ./target/native-creds-sc /work/application                                                                              0.0s
 => exporting to image                                                                                                                                                  0.0s
 => => exporting layers                                                                                                                                                 0.0s
 => => writing image sha256:22cbf7f5c230c8b81b40524e4f339355b72abe88ef944aa86e2b2fbf990333c5                                                                            0.0s
 => => naming to docker.io/diego/nativesc:V1                                                                                                                            0.0s
```

### Running container with native image
```
❯ docker run diego/nativesc:V1 -p 8080:8080
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.0)

2024-06-28T08:07:35.420Z  INFO 1 --- [           main] c.g.d.sandboxspring.Application          : Starting AOT-processed Application using Java 21 with PID 1 (/work/application started by root in /work)
2024-06-28T08:07:35.420Z  INFO 1 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2024-06-28T08:07:35.482Z  INFO 1 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2024-06-28T08:07:35.513Z  INFO 1 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
2024-06-28T08:07:35.514Z  INFO 1 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 0.115 seconds (process running for 0.122)
```

### Startup memory
```
docker stats
```
```
CONTAINER ID   NAME                CPU %     MEM USAGE / LIMIT     MEM %     NET I/O       BLOCK I/O       PIDS
88d8ee2287ad   priceless_wozniak   0.00%     36.29MiB / 62.65GiB   0.06%     5.52kB / 0B   106kB / 102kB   6
```

### Using the Application
```
❯ ./test-container-native.sh
Calling encryption. Result: sUsXwtpjcTMPQed2ZoJbcg==
Calling decryption. Result: SpringRocks
```
```
CONTAINER ID   NAME                CPU %     MEM USAGE / LIMIT     MEM %     NET I/O         BLOCK I/O       PIDS
88d8ee2287ad   priceless_wozniak   0.00%     46.92MiB / 62.65GiB   0.07%     7.86kB / 821B   106kB / 102kB   8
```