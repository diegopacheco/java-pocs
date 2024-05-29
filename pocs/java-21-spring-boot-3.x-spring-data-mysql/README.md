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

 :: Spring Boot ::                (v3.3.0)

2024-05-28T22:29:59.604-07:00  INFO 21821 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 21.0.2 with PID 21821 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/java-21-spring-boot-3.x-spring-data-mysql/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/java-21-spring-boot-3.x-spring-data-mysql)
2024-05-28T22:29:59.607-07:00  INFO 21821 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2024-05-28T22:30:00.636-07:00  INFO 21821 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JDBC repositories in DEFAULT mode.
2024-05-28T22:30:00.798-07:00  INFO 21821 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 158 ms. Found 1 JDBC repository interface.
2024-05-28T22:30:01.301-07:00  INFO 21821 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2024-05-28T22:30:01.736-07:00  INFO 21821 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@4bb147ec
2024-05-28T22:30:01.737-07:00  INFO 21821 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2024-05-28T22:30:02.611-07:00  INFO 21821 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2024-05-28T22:30:03.015-07:00  INFO 21821 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
2024-05-28T22:30:03.042-07:00  INFO 21821 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 3.771 seconds (process running for 4.188)
Spring Boot 3.3.0 up and running! 
Refreshing connection... TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@1537e43 - DS: HikariDataSource (HikariPool-1)
Connection refreshed!
TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@1537e43 - DS: HikariDataSource (HikariPool-1)
DB Loader done. 
TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@1537e43 - DS: HikariDataSource (HikariPool-1)
TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@1537e43 - DS: HikariDataSource (HikariPool-1)
TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@1537e43 - DS: HikariDataSource (HikariPool-1)
```