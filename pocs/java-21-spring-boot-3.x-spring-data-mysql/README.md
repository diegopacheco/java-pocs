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

2024-05-28T22:35:53.047-07:00  INFO 23193 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 21.0.2 with PID 23193 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/java-21-spring-boot-3.x-spring-data-mysql/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/java-21-spring-boot-3.x-spring-data-mysql)
2024-05-28T22:35:53.051-07:00  INFO 23193 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2024-05-28T22:35:53.968-07:00  INFO 23193 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JDBC repositories in DEFAULT mode.
2024-05-28T22:35:54.115-07:00  INFO 23193 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 143 ms. Found 1 JDBC repository interface.
New DataSource requested...
2024-05-28T22:35:54.640-07:00  INFO 23193 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2024-05-28T22:35:55.071-07:00  INFO 23193 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@4bb147ec
2024-05-28T22:35:55.073-07:00  INFO 23193 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
New TXManager requested...
2024-05-28T22:35:55.976-07:00  INFO 23193 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2024-05-28T22:35:56.403-07:00  INFO 23193 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
2024-05-28T22:35:56.440-07:00  INFO 23193 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 3.778 seconds (process running for 4.167)
Spring Boot 3.3.0 up and running! 
Refreshing connection... TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@1537e43 - DS: HikariDataSource (HikariPool-1)
Connection refreshed!
TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@1537e43 - DS: HikariDataSource (HikariPool-1)
DB Loader done. 
TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@1537e43 - DS: HikariDataSource (HikariPool-1)
TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@1537e43 - DS: HikariDataSource (HikariPool-1)
TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@1537e43 - DS: HikariDataSource (HikariPool-1)
TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@1537e43 - DS: HikariDataSource (HikariPool-1)
TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@1537e43 - DS: HikariDataSource (HikariPool-1)
TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@1537e43 - DS: HikariDataSource (HikariPool-1)
```