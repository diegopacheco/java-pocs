### Build

```bash
./mvnw clean install
```

### Result

```bash
[INFO] Attaching agents: []

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v4.0.0)

2025-11-21T21:27:41.597-08:00  INFO 44651 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 25 with PID 44651 (/Users/diegopacheco/git/diegopacheco/java-pocs/pocs/java-25-sb-4x/target/classes started by diegopacheco in /Users/diegopacheco/git/diegopacheco/java-pocs/pocs/java-25-sb-4x)
2025-11-21T21:27:41.598-08:00  INFO 44651 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2025-11-21T21:27:42.059-08:00  INFO 44651 --- [           main] o.s.boot.tomcat.TomcatWebServer          : Tomcat initialized with port 8081 (http)
2025-11-21T21:27:42.066-08:00  INFO 44651 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-11-21T21:27:42.066-08:00  INFO 44651 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/11.0.14]
2025-11-21T21:27:42.086-08:00  INFO 44651 --- [           main] b.w.c.s.WebApplicationContextInitializer : Root WebApplicationContext: initialization completed in 463 ms
2025-11-21T21:27:42.307-08:00  INFO 44651 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2025-11-21T21:27:42.336-08:00  INFO 44651 --- [           main] o.s.boot.tomcat.TomcatWebServer          : Tomcat started on port 8081 (http) with context path '/'
2025-11-21T21:27:42.340-08:00  INFO 44651 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 0.92 seconds (process running for 1.073)
Spring Boot 4.0.x working!
2025-11-21T21:27:50.738-08:00  INFO 44651 --- [nio-8081-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-11-21T21:27:50.739-08:00  INFO 44651 --- [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-11-21T21:27:50.740-08:00  INFO 44651 --- [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
```