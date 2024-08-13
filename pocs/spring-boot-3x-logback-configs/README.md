### Build
```bash
./mvnw clean install
```
### Features

* Logging with colors on console `org.springframework.boot.logging.logback.ColorConverter`
* Passing log config file with `-Dlogging.config`
* Log rotate via `ch.qos.logback.core.rolling.RollingFileAppender`
* Default Spring profile `local` or what you pass `./run.sh dev`
* Actuator shutdown endpoint and graceful shutdown `curl http://localhost:8080/actuator/shutdown -x POST`
* Async file appender to improve performance `ch.qos.logback.classic.AsyncAppender`

### Result

```
❯ ./run.sh
using log config file: ./config/logback-spring.xml
Using Spring profile: local
[INFO] Scanning for projects...
[INFO] 
[INFO] --< com.github.diegopacheco.javapocs:spring-boot-3x-logback-configs >---
[INFO] Building spring-boot-3x-logback-configs 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ war ]---------------------------------
[INFO] 
[INFO] >>> spring-boot:3.3.2:run (default-cli) > test-compile @ spring-boot-3x-logback-configs >>>
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ spring-boot-3x-logback-configs ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Copying 0 resource from src/main/resources to target/classes
[INFO] 
[INFO] --- compiler:3.13.0:compile (default-compile) @ spring-boot-3x-logback-configs ---
[INFO] Nothing to compile - all classes are up to date.
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ spring-boot-3x-logback-configs ---
[INFO] Copying 0 resource from src/test/resources to target/test-classes
[INFO] 
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ spring-boot-3x-logback-configs ---
[INFO] Nothing to compile - all classes are up to date.
[INFO] 
[INFO] <<< spring-boot:3.3.2:run (default-cli) < test-compile @ spring-boot-3x-logback-configs <<<
[INFO] 
[INFO] 
[INFO] --- spring-boot:3.3.2:run (default-cli) @ spring-boot-3x-logback-configs ---
[INFO] Attaching agents: []

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.2)

2024-08-12 23:29:57 INFO  INFO  c.g.d.sandboxspring.Application - Starting Application using Java 21 with PID 526052 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-logback-configs/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-logback-configs)
2024-08-12 23:29:57 INFO  INFO  c.g.d.sandboxspring.Application - The following 1 profile is active: "local"
2024-08-12 23:29:58 INFO  INFO  o.s.b.a.e.web.EndpointLinksResolver - Exposing 1 endpoint beneath base path '/actuator'
2024-08-12 23:29:59 INFO  INFO  o.s.b.w.e.netty.NettyWebServer - Netty started on port 8080 (http)
2024-08-12 23:29:59 INFO  INFO  c.g.d.sandboxspring.Application - Started Application in 1.852 seconds (process running for 2.099)
Spring Boot 3.3.x working! 
```