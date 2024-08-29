### Build
```bash
./mvnw clean install
```

### Results

application.properties
```
spring.main.log-startup-info=true
```

```
   .   ____          _            __ _ _
  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
 ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
   '  |____| .__|_| |_|_| |_\__, | / / / /
  =========|_|==============|___/=/_/_/_/

:: Spring Boot ::                (v3.3.2)

2024-08-28T21:20:52.336-07:00  INFO 1252576 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 21 with PID 1252576 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-startup-info/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-startup-info)
2024-08-28T21:20:52.341-07:00  INFO 1252576 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2024-08-28T21:20:54.234-07:00  INFO 1252576 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2024-08-28T21:20:54.781-07:00  INFO 1252576 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
2024-08-28T21:20:54.822-07:00  INFO 1252576 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 3.085 seconds (process running for 3.613)
Spring Boot 3.3.x working!
```

application.properties
```
spring.main.log-startup-info=false
```
```

    .   ____          _            __ _ _
   /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
  ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
   \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
    '  |____| .__|_| |_|_| |_\__, | / / / /
   =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.2)

2024-08-28T21:23:48.976-07:00  INFO 1253251 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2024-08-28T21:23:49.556-07:00  INFO 1253251 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
Spring Boot 3.3.x working! 
```
