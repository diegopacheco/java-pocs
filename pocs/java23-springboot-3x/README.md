### Build
```bash
./mvnw clean install
```
### Result

```

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.3)

2024-09-19T05:29:58.270-07:00  INFO 3793550 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 23 with PID 3793550 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/java23-springboot-3x/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/java23-springboot-3x)
2024-09-19T05:29:58.273-07:00  INFO 3793550 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2024-09-19T05:29:59.123-07:00  INFO 3793550 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-09-19T05:29:59.138-07:00  INFO 3793550 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-09-19T05:29:59.139-07:00  INFO 3793550 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.28]
2024-09-19T05:29:59.181-07:00  INFO 3793550 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-09-19T05:29:59.182-07:00  INFO 3793550 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 849 ms
2024-09-19T05:29:59.599-07:00  INFO 3793550 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2024-09-19T05:29:59.651-07:00  INFO 3793550 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2024-09-19T05:29:59.666-07:00  INFO 3793550 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 1.682 seconds (process running for 2.063)
Spring Boot 3.3.x working! 
2024-09-19T05:30:07.359-07:00  INFO 3793550 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2024-09-19T05:30:07.359-07:00  INFO 3793550 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2024-09-19T05:30:07.360-07:00  INFO 3793550 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
```