### Build

```bash
./mvnw clean install
```

### Run

```
./run.sh
```

```

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.2)

2025-02-08T16:39:44.677-08:00  INFO 66335 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 21 with PID 66335 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-gson/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-gson)
2025-02-08T16:39:44.680-08:00  INFO 66335 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2025-02-08T16:39:45.880-08:00  INFO 66335 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2025-02-08T16:39:45.895-08:00  INFO 66335 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-02-08T16:39:45.895-08:00  INFO 66335 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.34]
2025-02-08T16:39:45.937-08:00  INFO 66335 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-02-08T16:39:45.938-08:00  INFO 66335 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1209 ms
2025-02-08T16:39:46.553-08:00  INFO 66335 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2025-02-08T16:39:46.608-08:00  INFO 66335 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2025-02-08T16:39:46.625-08:00  INFO 66335 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 2.391 seconds (process running for 2.75)
Spring Boot 3.4.x working!
```

### Test

```bash
curl -i http://localhost:8080/champs
```

```
HTTP/1.1 200
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Sun, 09 Feb 2025 00:37:24 GMT

[
  {
    "name": "John Doe",
    "age": 40,
    "address": "1234 main street, alaska",
    "phone": "555-0430-245"
  },
  {
    "name": "Marry Doe",
    "age": 40,
    "address": "2355 main street, alaska",
    "phone": "555-5874-5566"
  },
  {
    "name": "Champ",
    "age": 50,
    "address": "2354 champ elysiums",
    "phone": "444-5555-4444"
  }
]%
```
 